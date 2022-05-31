# What Is GraphQL?
* Traditional REST APIs work with the concept of Resources that the server manages. We can manipulate these resources in some standard ways, following the various HTTP verbs. This works very well as long as our API fits the resource concept, but quickly falls apart when we need to deviate from it.
* This also suffers when the client needs data from multiple resources at the same time, such as requesting a blog post and the comments. Typically, this is solved either by having the client make multiple requests, or having the server supply extra data that might not always be required, leading to larger response sizes.
* GraphQL offers a solution to both of these problems. It allows the client to specify exactly what data it desires, including from navigating child resources in a single request, and allows for multiple queries in a single request.
* It also works in a much more RPC manner, using named queries and mutations, instead of a standard mandatory set of actions. This works to put the control where it belongs, with the API developer specifying what's possible, and the API consumer specifying what's desired.
* For example, a blog might allow the following query
```
query {
    recentPosts(count: 10, offset: 0) {
        id
        title
        category
        author {
            id
            name
            thumbnail
        }
    }
}
```
* This query will:
	* request the ten most recent posts
	* for each post, request the ID, title, and category
	* for each post, request the author, returning the ID, name, and thumbnail
	* In a traditional REST API, this either needs 11 requests, one for the posts and 10 for the authors, or needs to include the author details in the post details

# GraphQL Schemas
* The GraphQL server exposes a schema describing the API. This scheme consists of type definitions. Each type has one or more fields, which each take zero or more arguments, and return a specific type.
* The graph is derived from the way these fields are nested with each other. Note that the graph doesn't need to be acyclic, cycles are perfectly acceptable, but it is directed. That is, the client can get from one field to its children, but it can't automatically get back to the parent unless the schema defines this explicitly.
* An example GraphQL Schema for a blog may contain the following definitions describing a Post, the Author of the post, and a root query to get the most recent posts on the blog
```
type Post {
    id: ID!
    title: String!
    text: String!
    category: String
    author: Author!
}

type Author {
    id: ID!
    name: String!
    thumbnail: String
    posts: [Post]!
}

# The Root Query for the application
type Query {
    recentPosts(count: Int, offset: Int): [Post]!
}

# The Root Mutation for the application
type Mutation {
    writePost(title: String!, text: String!, category: String) : Post!
}
```
* The `!` at the end of some names indicates that it's a non-nullable type. Any type that doesn't have this can be null in the response from the server. The GraphQL service handles these correctly, allowing us to request child fields of nullable types safely.
* The GraphQL Service also exposes the schema itself using a standard set of fields, allowing any client to query for the schema definition ahead of time.
* This allows the client to automatically detect when the schema changes, and allows for clients that dynamically adapt to the way the schema works. One incredibly useful example of this is the GraphiQL tool, which allows us to interact with any GraphQL API.

# Introducing GraphQL Spring Boot Starter
* All we need for this to work is the correct dependencies
```
<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphql-spring-boot-starter</artifactId>
    <version>5.0.2</version>
</dependency>
<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphql-java-tools</artifactId>
    <version>5.2.4</version>
</dependency>
```
* Spring Boot will automatically pick these up and set up the appropriate handlers to work
* By default, this will expose the GraphQL Service on the `/graphql` endpoint of our application, and will accept POST requests containing the GraphQL Payload. We can customize this endpoint in our application.properties file if necessary

# Writing the Schema
* The GraphQL Tools library works by processing GraphQL Schema files to build the correct structure, and then wires special beans to this structure. The Spring Boot GraphQL starter automatically finds these schema files.
* We need to save these files with the extension `.graphqls` and they can be present anywhere on the classpath. We can also have as many of these files as desired, so we can split the scheme up into modules as desired.
* The one requirement is that there must be exactly one root query, and up to one root mutation. We can't split this across files, unlike the rest of the scheme. This is a limitation of the GraphQL Schema definition itself, not the Java implementation.

# Root Query Resolver
* The root query needs to have special beans defined in the Spring context to handle the various fields in this root query. Unlike the schema definition, there's no restriction that there only be a single Spring bean for the root query fields
* The only requirements are that the beans implement `graphql.kickstart.tools.GraphQLQueryResolver`, and that every field in the root query from the scheme has a method in one of these classes with the same name
```
public class Query implements GraphQLQueryResolver {
    private PostDao postDao;
    public List<Post> getRecentPosts(int count, int offset) {
        return postsDao.getRecentPosts(count, offset);
    }
}
```
* The names of the method must be one of the following, in this order:
	* <field>
	* is<field> – only if the field is of type Boolean
	* get<field>
* The method must have parameters that correspond to any parameters in the GraphQL schema, and may optionally take a final parameter of type `graphql.schema.DataFetchingEnvironment`
* The method must also return the correct return type for the type in the GraphQL scheme, as we're about to see. We can use any simple types, String, Int, List, etc., with the equivalent Java types, and the system just maps them automatically
* The above defines the method `getRecentPosts`, which we'll use to handle any GraphQL queries for the `recentPosts` field in the schema defined earlier

# Using Beans to Represent Types
* Every complex type in the GraphQL server is represented by a Java bean, whether loaded from the root query or from anywhere else in the structure. The same Java class must always represent the same GraphQL type, but the name of the class isn't necessary.
* Fields inside the Java bean will directly map onto fields in the GraphQL response based on the name of the field
```
public class Post {
    private String id;
    private String title;
    private String category;
    private String authorId;
}
```
* Any fields or methods on the Java bean that don't map on to the GraphQL schema will be ignored, but won't cause problems. This is important for `field resolvers` to work
* For example, here the field authorId doesn't correspond to anything in the schema we defined earlier, but it will be available to use for the next step

# Field Resolvers for Complex Values
* Sometimes, the value of a field is non-trivial to load. This might involve database lookups, complex calculations, or anything else. GraphQL Tools has a concept of a `field resolver` that's used for this purpose. These are Spring beans that can provide values in place of the data bean.
* The field resolver is any bean in the Spring Context that has the same name as the data bean, with the suffix Resolver, and implements the `graphql.kickstart.tools.GraphQLResolver` interface. Methods on the field resolver bean follow all of the same rules as on the data bean, but also provide the data bean itself as a first parameter.
* If a field resolver and the data bean both have methods for the same GraphQL field, then the field resolver will take precedence
```
public class PostResolver implements GraphQLResolver<Post> {
    private AuthorDao authorDao;

    public Author getAuthor(Post post) {
        return authorDao.getAuthorById(post.getAuthorId());
    }
}
```
* That these field resolvers load from the Spring context is important. This allows them to work with any other Spring managed beans, e.g. DAOs.
* Importantly, if the client doesn't request a field, then the GraphQL Server won't do the work to retrieve it. This means that if a client retrieves a Post and doesn't ask for the Author, the getAuthor() method above won't be executed, and the DAO call won't be made

# Nullable Values
* The GraphQL Schema has the concept that some types are nullable and others aren't.
* We handle this in the Java code by directly using null values. Conversely, we can use the new Optional type from Java 8 directly for nullable types, and the system will do the correct thing with the values.
* This is very useful, as it means that our Java code is more obviously the same as the GraphQL schema from the method definitions

# Mutations
* So far, everything we've done has been about retrieving data from the server. GraphQL also has the ability to update the data stored on the server by means of mutations
* From the point of view of the code, there's no reason that a Query can't change data on the server. We could easily write query resolvers that accept arguments, save new data, and return those changes. Doing this will cause surprising side effects for the API clients, and is considered bad practice
* Instead, Mutations should be used to inform the client that this will cause a change to the data being stored.
* Mutations are defined in the Java code by using classes that implement `graphql.kickstart.tools.GraphQLMutationResolver`, instead of `graphql.kickstart.tools.GraphQLQueryResolver`.
* Otherwise, all the same rules apply as for queries. The return value from a Mutation field is then treated exactly the same as from a Query field, allowing nested values to be retrieved as well
```
public class Mutation implements GraphQLMutationResolver {
    private PostDao postDao;

    public Post writePost(String title, String text, String category) {
        return postDao.savePost(title, text, category);
    }
}
```

# Introducing GraphiQL
* GraphQL also has a companion tool called `GraphiQL`. This is a UI that's able to communicate with any GraphQL Server, and execute queries and mutations against it. A downloadable version of it exists as an Electron app, and can be retrieved from [here](https://github.com/skevy/graphiql-app).
* It's also possible to include the web-based version of GraphiQL in our application automatically by adding the GraphiQL Spring Boot Starter dependency
```
<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphiql-spring-boot-starter</artifactId>
    <version>5.0.2</version>
</dependency>
```
* This will only work if we're hosting our GraphQL API on the default endpoint of `/graphql`. we'll need the standalone application if that's not the case

# Graphql Java Git Repo
* [https://github.com/graphql-java-kickstart](https://github.com/graphql-java-kickstart)
