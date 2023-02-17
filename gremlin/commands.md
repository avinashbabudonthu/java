# Gremlin commands
* Reference to below gremlin commands - https://tinkerpop.apache.org/docs/current/tutorials/getting-started/
* Download gremlin console from [here](https://www.apache.org/dyn/closer.lua/tinkerpop/3.6.1/apache-tinkerpop-gremlin-console-3.6.1-bin.zip)
* open gremlin console
```
C:\....\apache-tinkerpop-gremlin-console-3.6.1-bin\apache-tinkerpop-gremlin-console-3.6.1>bin\gremlin.bat
```
* create modern graph
```
graph = TinkerFactory.createModern()
```
* create graph
```
g = traversal().withEmbedded(graph)
```
* All vertices
```
g.V()
```
* Vertex with id 1
```
g.V(1)
```
* get name of the vertex with id 1
```
g.V(1).values("name")
```
* Edges coming out from vertext 1
```
g.V(1).outE()
```
* Edge with label `knows` coming out from vertex 1
```
g.V(1).outE("knows")
```
* name of the vertex with knows edge from vertix 1
```
g.V(1).outE("knows").inV().values("name")
g.V(1).out("knows").values("name")
```
* name of the vertex with knows edge from vertex and vertex with property age greater than 30
```
g.V(1).out("knows").has("age", gt(30)).values("name")
```
* name of the vertex with knows edge from vertex and vertex with property age less than 30
```
g.V(1).out("knows").has("age", lt(30)).values("name")
```
* * name of the vertex with knows edge from vertex and vertex with property age equal to 30
```
g.V(1).out("knows").has("age", eq(30)).values("name")
```
------
* Create new graph
```
graph = TinkerGraph.open()
```
* Create graph traversal
```
g = traversal().withEmbedded(graph)
```
* Create vertex v1
```
v1 = g.addV("person").property(id, 1).property("name", "marko").property("age", 29).next()
```
* Create vertex v2
```
v2 = g.addV("software").property(id, 3).property("name", "lop").property("lang", "java").next()
```
* Create edge from v1 to v2
```
g.addE("created").from(v1).to(v2).property(id,9).property("weight", 0.4)
```
* All vertices
```
g.V()
```
* Vertex with name property equal to marko
```
g.V(1).has("name", eq("marko")).values("name")
g.V().has("name", eq("marko"))
g.V().has("person", "name", "marko")
```
* Edge with label created from vertex with label as person and name as marko 
```
g.V().has("person", "name", "marko").outE("created")
```
* Vertices with edge created from vertex with name marko
```
g.V().has("person", "name", "marko").outE("created").inV()
g.V().has("person", "name", "marko").out("created")
```
* Name of vertices with edge created from vertex with name marko
```
g.V().has("person", "name", "marko").out("created").values("name")
```
------
* Create modern graph
```
graph = TinkerFactory.createModern()
```
* Create graph traversal
```
g = traversal().withEmbedded(graph)
```
* ages of vertices with name in vadas or marko
```
g.V().has("person", "name", within("vadas","marko")).values("age")
```
* average of ages of vertices with name in vadas or marko
```
g.V().has("person", "name", within("vadas", "marko")).values("age").mean()
```
* To vertex with created edge from person with name marko vertex
```
g.V().has("person", "name", "marko").out("created")
```
* Vertices with created as in edge
```
g.V().has("person", "name", "marko").out("created").in("created")
```
* Name and age of vertices with created as in edge
```
g.V().has("person", "name", "marko").out("created").in("created").values("name", "age")
```
* Vertices with created as in edge exluding marko
```
g.V().has("person", "name", "marko").as("exclude").out("created").in("created").where(neq("exclude")).values("name")
```
* Gremlin to iterate through all vertices and traverse out twice from each. Gremlin will label each vertex in that path with "a", "b" and "c", respectively. We can then use select to extract the contents of that label
```
g.V().as("a").out().as("b").out().as("c").select("a", "b", "c")
```
* Group vertices by label
```
g.V().group().by(label)
```
* Group vertices by label. display names of those vertices
```
g.V().group().by(label).by("name")
```
------
* Check all vertices with properties
```
g.V().valueMap()
```
* Count vertices
```
g.V().count()
```
* Get all properties of vertex with id 1
```
g.V(1).valueMap()
```
* Print node label
```
g.V(id).label()
```
* Vertex with id `outVertextId` from vertex with id `id1` with out edge label `edgeLabel1`
```
g.V("id1").out("edgeLabel1").hasId("outVertextId")
```
* node with proeprty name containing. `label` is optional
```
g.V().has("property", TextP.containing("value"))
g.V().has("name", TextP.containing("ji"))

g.V().has("label", "property", TextP.containing("value"))
g.V().has("person", "name", TextP.containing("ji"))
```