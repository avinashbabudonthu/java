# What is Graph
* A graph is a pictorial representation of objects which are connected by some pair of links.
* A graph contains two elements: 
  * Nodes (Vertices)
  * Relationships (Edges)
------
# 2 types of graphdbs:
* Property Graph
* W3C RDF - Resource Description Framework
------
# Query languages:
* Property Graph - Open source Apache TinkerPop Gremlin Traveral Language
* W3c RDF - W3C standard SPARQL query languages
------
# Graph data structure contains
* Nodes (or) Vertices
* Relationships (or) Links (or) Edges
------
# Property Graph:
* Consists of nodes and edges
* These nodes and edges can have properties on them
* Apache TinkerPop is open source implementation of property graph
* Query language for Apache TinkerPop (infact property graph) is `Gremlin`
------
# Resource Description Framework RDF
* W3C recommendation
* Originally build to describe resources on the web
* RDF expresses graphs in terms of `triples`
	* Subject
	* Predicate
	* Object
* We query RDF graph using `SPARQL`
* SPARQL is declarative graph query language for RDF
------
# What is Graph database
* A graph database is a database which is used to model the data in the form of graph. It store any kind of data using:
	* Nodes
	* Relationships
	* Properties
* `Nodes:` Nodes are the records/data in graph databases. Data is stored as properties and properties are simple name/value pairs.
* Nodes can be grouped together by applying a Label to each member. A node can have zero or more labels. Labels do not have any properties. Storing data in Neo4j is similar to add more records in other databases.
* `Relationships:` It is used to connect nodes. It specifies how the nodes are related.
	* Relationships always have direction.
	* Relationships always have a type.
	* Relationships form patterns of data.
* Popular Graph Databases
	* Neo4j is the most popular Graph Database. Other Graph Databases are
	* Oracle NoSQL Database
	* OrientDB
	* HypherGraphDB
	* GraphBase
	* InfiniteGraph
	* AllegroGraph
## Why GraphDB
* Graph database is very useful now a day because in graph databases data exist in the form of the relationship between different objects. The relationship between the data is more valuable than the data itself.
* Relational databases store highly structured data which have several records storing the same type of data so they can be used to store structured data and, they do not store the relationships between the data while graph databases store relationships and connections as first-class entities.
* The data model for graph databases is simple compared to other databases and, they can be used with OLTP systems. They provide features like transactional integrity and operational availability.

## Graph Database vs. RDBMS
* Differences between Graph database and RDBMS
	* In graph database, data is stored in graphs.	In RDBMS, data is stored in tables.
	* In graph database there are nodes.	In RDBMS, there are rows.
	* In graph database there are properties and their values.	In RDBMS, there are columns and data.
	* In graph database the connected nodes are defined by relationships.	In RDBMS, constraints are used instead of that.
	* In graph database traversal is used instead of join.	In RDBMS, join is used instead of traversal.
------
# GraphDB vs NoSQL Database
* Following are some points which specify why GraphDb is better than other NoSQL databases:
	* Most NoSQL databases store sets of disconnected aggregates. This makes it difficult to use them for connected data and graphs.
	* One well-known strategy for adding relationships to such stores is to embed an aggregate's identifier inside the field belonging to another aggregate - effectively introducing foreign keys.
	* But this requires joining aggregates at the application level, which quickly becomes prohibitively expensive.
* See the use cases of different type of databases:
	* Relational database: It is represented in tabular form so it is best for calculating the income.
	* Key-Value Store: It is best for building a shopping cart.
	* NoSQL databases: It is stored as a document so, it is best for storing structured product information.
	* GraphDB: It follows a graph structure. It is best for describing how a user got from point A to point B.
