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
* The “!” at the end of some names indicates that it's a non-nullable type. Any type that doesn't have this can be null in the response from the server. The GraphQL service handles these correctly, allowing us to request child fields of nullable types safely.
* The GraphQL Service also exposes the schema itself using a standard set of fields, allowing any client to query for the schema definition ahead of time.
* This allows the client to automatically detect when the schema changes, and allows for clients that dynamically adapt to the way the schema works. One incredibly useful example of this is the GraphiQL tool, which allows us to interact with any GraphQL API.
