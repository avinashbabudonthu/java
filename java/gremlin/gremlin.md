# Gremlin Materials in study order
* https://tinkerpop.apache.org/docs/current/tutorials/getting-started/
* Gremlin Cheat Sheet 101 - https://dkuppitz.github.io/gremlin-cheat-sheet/101.html
* Gremlin Cheat Sheet 102 - https://dkuppitz.github.io/gremlin-cheat-sheet/102.html
* http://www.kelvinlawrence.net/book/PracticalGremlin.pdf
* https://github.com/krlawrence/graph
* http://sql2gremlin.com/
* Gremlify - Tool for Playing around with the graphs - https://gremlify.com/
* Some Apache Gremlin Posts	- https://www.doanduyhai.com/blog/?cat=58
* https://tinkerpop.apache.org/docs/3.0.2-incubating/#intro
------
# Gremlin Console
* Download gremlin console - https://www.apache.org/dyn/closer.lua/tinkerpop/3.6.1/apache-tinkerpop-gremlin-console-3.6.1-bin.zip
* open gremlin console
```
C:\....\apache-tinkerpop-gremlin-console-3.6.1-bin\apache-tinkerpop-gremlin-console-3.6.1>bin\gremlin.bat
```
* create modern graph. This contains graph with 6 nodes for practice
```
graph = TinkerFactory.createModern()
```
* create graph traversal
```
g = traversal().withEmbedded(graph)
```
* Above 2 commands combined as follows
```
g = TinkerFactory.createModern().traversal()
```
* practice graph with more nodes and edges
```
gremlin> g = TinkerFactory.createGratefulDead().traversal()
==>graphtraversalsource[tinkergraph[vertices:808 edges:8049], standard]
```
* count nodes
```
g.V().count()
```
* exit gremlin console
```
:exit
```
* clear gremlin console
```
:cls
:C
```
* Gremlin console docker container - https://hub.docker.com/r/tinkerpop/gremlin-console
------
# Gremlin commands
* Setup gremlin console to practice below commands - [Gremlin Console](#Gremlin-Console)
* create graph object with 6 nodes for practice
```
graph = TinkerFactory.createModern()
```
* above command creates following graph\
![picture](imgs/tinkerpop-modern.png)
* create new graph without existing nodes or edges
```
graph = TinkerGraph.open()
```
* create graph traversal
```
g = traversal().withEmbedded(graph)
```
* Above 2 commands combined as follows
```
g = TinkerFactory.createModern().traversal()
```
* practice graph with more nodes and edges
```
gremlin> g = TinkerFactory.createGratefulDead().traversal()
==>graphtraversalsource[tinkergraph[vertices:808 edges:8049], standard]
```
* get all nodes
```
g.V()
```
* count nodes
```
gremlin> g.V().count()
==>6

gremlin> g.V().fold()
==>[v[1],v[2],v[3],v[4],v[5],v[6]]

gremlin> g.V().fold().count()
==>1

gremlin> g.V().fold().count(local)
==>6
```
* get nodes by label
```
g.V().hasLabel("labelValue")
```
* get all edges
```
g.E()
```
* count all edges
```
g.E().count()
```
* Row number or limit the number of nodes
```
g.V().limit(10)

g.V().hasLabel("labelValue").limit(10)
```
* node with id 1
```
g.V(1)

g.V().hasId(1)

gremlin> g.V().hasId(1, 2, 3, 4)
==>v[1]
==>v[2]
==>v[3]
==>v[4]
```
* get node `id`
```
g.V().limit(1).id()
```
* get node `label`
```
g.V(id).label()
```
* sort by label asc
```
g.V().label().sort(asc)
```
* sort by label desc
```
g.V().label().sort(desc)
```
* get node by label
```
g.V().hasLabel("labelValue")
```
* remove duplicates
```
g.V().hasLabel("labelValue").dedup()
```
* drop remove delete nodes with label
```
g.V().hasLabel("labelValue").drop()
```
* drop remove delete node with id
```
g.V(id).drop()
```
* drop remove delete property
```
g.V().hasLabel("labelName").properties("propertyName").drop()
```
* get edge with label
```
g.E().hasLabel("labelName")
```
* drop remove delete edge with label
```
g.E().hasLabel("labelName").drop()
```
* get `name` property of node with id 1
```
g.V(1).values("name")
```
* out edges from node with id 1
```
g.V(1).outE()
```
* edge with label `knows` coming out from node with id 1
```
g.V(1).outE("knows")
```
* nodes with out edge `knows` from node 1
```
g.V(1).outE("knows").inV().values("name")
g.V(1).out("knows").values("name")
g.V(1).out("knows")
```
* nodes with edge `knows` from node 1 and `age > 30`
```
g.V(1).out("knows").has("age", gt(30)).values("name")
```
* nodes with out edge `knows` from node 1 and `age < 30`
```
g.V(1).out("knows").has("age", lt(30)).values("name")
```
* nodes with out edge `knows` from node 1 and `age == 30`
```
g.V(1).out("knows").has("age", eq(30)).values("name")
```
* create node n1. label - person, properties - id, name, age
```
n1 = g.addV("person").property(id, 1).property("name", "marko").property("age", 29).next()
```
* create node n2. label - software, properties - id, name, lang
```
n2 = g.addV("software").property(id, 3).property("name", "lop").property("lang", "java").next()
```
* create edge from n1 to n2. properties - id, weight
```
g.addE("created").from(n1).to(n2).property(id,9).property("weight", 0.4)
```
* add edge between existing nodes. properties - weight
```
g.V("node1Id").as("n1").V("node2Id").as("n2").addE("edgeLabel").from("n1").to("n2").propety("weight", 0.5)
```
* add multiple nodes and mulitple edges and respective properties
```
g.addV('company').property('name','datastax').as('ds').
addV('software').property('name','dse graph').as('dse').
addV('software').property('name','tinkerpop').as('tp').
addE('develops').from('ds').to('dse').
addE('uses').from('dse').to('tp').
addE('likes').from('ds').to('tp').
iterate()
```
* node with name property equal to marko
```
g.V().has("name", eq("marko")).values("name")
g.V().has("name", eq("marko"))
```
* node with `label==person`, `name==marko`
```
g.V().has("label", "property", "value")
g.V().has("person", "name", "marko")
```
* out edge with `label==created` from node with `label==person` and `name==marko` 
```
g.V().has("person", "name", "marko").outE("created")
```
* nodes with out edge `label==created` from node with `label==person` and `name==marko`
```
g.V().has("person", "name", "marko").outE("created").inV()
g.V().has("person", "name", "marko").out("created")
```
* `age` property of nodes with `label==person` and `name in (vadas ,marko)`
```
g.V().has("person", "name", within("vadas","marko")).values("age")
```
* average `age` of nodes with `label==person` and `name in (vadas ,marko)`
```
g.V().has("person", "name", within("vadas", "marko")).values("age").mean()
```
* node with out edge `label==created` from node with `label==person` and `name=marko`
```
g.V().has("person", "name", "marko").out("created")
```
* nodes providing `in` edge with `label==created` to the node that has `out` edge with `label==created` from node with `label==person and name==marko`
```
g.V().has("person", "name", "marko").out("created").in("created")

gremlin> g.V().has("person", "name", "marko")
==>v[1]
gremlin> g.V().has("person", "name", "marko").out("created")
==>v[3]
gremlin> g.V().has("person", "name", "marko").out("created").in("created")  -> nodes providing `in` edge to v[3]
==>v[1]
==>v[4]
==>v[6]
```
* excluding node from final result nodes
```
g.V().has("person", "name", "marko").as("exclude").out("created").in("created").where(neq("exclude"))

gremlin> g.V().has("person", "name", "marko")
==>v[1]
gremlin> g.V().has("person", "name", "marko").as("exclude")
==>v[1]
gremlin> g.V().has("person", "name", "marko").as("exclude").out("created")
==>v[3]
gremlin> g.V().has("person", "name", "marko").as("exclude").out("created").in("created")
==>v[1]
==>v[4]
==>v[6]
gremlin> g.V().has("person", "name", "marko").as("exclude").out("created").in("created").where(neq("exclude"))
==>v[4]
==>v[6]
```
* Gremlin to iterate through all vertices and traverse out twice from each. Gremlin will label each vertex in that path with "a", "b" and "c", respectively. We can then use select to extract the contents of that label
```
g.V().as("a").out().as("b").out().as("c").select("a", "b", "c")
```
* order by label descending order
```
gremlin> g.V().order().by(label, desc).valueMap(true)
==>[id:3,label:software,name:[lop],lang:[java]]
==>[id:5,label:software,name:[ripple],lang:[java]]
==>[id:1,label:person,name:[marko],age:[29]]
==>[id:2,label:person,name:[vadas],age:[27]]
==>[id:4,label:person,name:[josh],age:[32]]
==>[id:6,label:person,name:[peter],age:[35]]
```
* order edges by `id`
```
gremlin> g.V().outE().order().by(id)
==>e[7][1-knows->2]
==>e[8][1-knows->4]
==>e[9][1-created->3]
==>e[10][4-created->5]
==>e[11][4-created->3]
==>e[12][6-created->3]
```
* group by label
```
g.V().group().by(label)
==>[software:[v[3],v[5]],person:[v[1],v[2],v[4],v[6]]]
```
* groupCount - get the count of each group
```
gremlin> g.V().groupCount().by(label)
==>[software:2,person:4]
```
* group by label and display names
```
gremlin> g.V().group().by(label).by("name")
==>[software:[lop,ripple],person:[marko,vadas,josh,peter]]
```
* get all nodes with properties. do not get `id` and `label`
```
g.V().valueMap()
```
* get properties of node
```
g.V("nodeId").properties()
```
* get all properties of nodes
```
gremlin> g.V().valueMap()
==>[name:[marko],age:[29]]
==>[name:[vadas],age:[27]]
```
* get `id` and `label` with other properties
```
gremlin> g.V().valueMap(true)
==>[id:1,label:person,name:[marko],age:[29]]
==>[id:2,label:person,name:[vadas],age:[27]]
```
* get `id` and `label` with other properties. Alternative to `valueMap(true)`. If property has list then `elementMap` returns 1st value from the list to display so better to use `valueMap(true)` which displays list of values
```
gremlin> g.V().elementMap()
==>[id:1,label:person,name:marko,age:29]
==>[id:2,label:person,name:vadas,age:27]
```
* node with id `outVertextId` from node with id `id1` with out edge label `edgeLabel1`
```
g.V("id1").out("edgeLabel1").hasId("outVertextId")
```
* node with property name containing. `label` is optional
```
g.V().has("property", TextP.containing("value"))
g.V().has("name", TextP.containing("ji"))

g.V().has("label", "property", TextP.containing("value"))
g.V().has("person", "name", TextP.containing("ji"))

gremlin> g.V().has("person", "name", TextP.containing("jo")).valueMap(true)
==>[id:4,label:person,name:[josh],age:[32]]

gremlin> g.V().has("person", "name", containing("jo")).valueMap(true)
==>[id:4,label:person,name:[josh],age:[32]]
```
* get all edges going out from node with label `labelName`
```
g.V().hasLabel("labelName").outE().label().dedup()
```
* get all `in` edges to node with `label=labelName`
```
g.V().hasLabel("labelName").inE().label().dedup()
```
* node with label and not has `property`
```
g.V().hasLabel("label").hasNot("property").valueMap()
g.V().hasLabel("label").hasNot("property").elementMap()
```
* keep the current element if the provided traversal emits a result. get all nodes which have out edges
```
gremlin> g.V().filter(outE())
==>v[1]
==>v[4]
==>v[6]
```
* keep the current element if the provided traversal doesn’t emit a result. get all nodes which don't have out edge
```
gremlin> g.V().not(outE())
==>v[2]
==>v[3]
==>v[5]
```
* keep the current element if it matches the predicate referencing another element. 
```
gremlin> g.V(1).as("other").
            out("knows").
            where(gt("other")).by("age").
            elementMap()
==>[id:4,label:person,name:josh,age:32]
```
* store the current element in the side-effect with the provided key
```
gremlin> g.V().hasLabel("person").store("n1").select("n1")
==>[v[1]]
==>[v[1],v[2]]
==>[v[1],v[2],v[4]]
==>[v[1],v[2],v[4],v[6]]
```
* store vs as
```
gremlin> g.V().hasLabel("person").store("n1").select("n1")
==>[v[1]]
==>[v[1],v[2]]
==>[v[1],v[2],v[4]]
==>[v[1],v[2],v[4],v[6]]

gremlin> g.V().hasLabel("person").as("n1").select("n1")
==>v[1]
==>v[2]
==>v[4]
==>v[6]
```
* aggregate - store all elements held by all current traversers in the side-effect with the provided key
```
gremlin> g.V().hasLabel("person").aggregate("n1").select("n1")
==>[v[1],v[2],v[4],v[6]]
==>[v[1],v[2],v[4],v[6]]
==>[v[1],v[2],v[4],v[6]]
==>[v[1],v[2],v[4],v[6]]
```
* union(branch1, branch2) - execute all branches and emit their results
```
gremlin> g.V().hasLabel("person")
        .union
            (
                out("created"),
                out("knows"),
                count()
            )
==>v[3]
==>v[5]
==>v[3]
==>v[3]
==>v[2]
==>v[4]
==>4
```
* choose(condition, true-branch, false-branch) - if/then/else-based traversal. If the condition matches (yields something), execute the true-branch, otherwise follow the false-branch.
```
gremlin> g.V().hasLabel("person").choose(has("age", gt(30)), constant("senior"), constant("junior"))
==>junior
==>junior
==>senior
==>senior
```
* min, max, sum, mean, count
```
gremlin> g.V().hasLabel("person").values("age").union(min(), max(), sum(), mean(), count())
==>27
==>35
==>123
==>30.75
==>4
```
* path
```
gremlin> g.V().outE().inV().path()
==>[v[1],e[9][1-created->3],v[3]]
==>[v[1],e[7][1-knows->2],v[2]]
==>[v[1],e[8][1-knows->4],v[4]]
==>[v[4],e[10][4-created->5],v[5]]
==>[v[4],e[11][4-created->3],v[3]]
==>[v[6],e[12][6-created->3],v[3]]

gremlin> g.V().outE().inV().path().by(label)
==>[person,created,software]
==>[person,knows,person]
==>[person,knows,person]
==>[person,created,software]
==>[person,created,software]
==>[person,created,software]

gremlin> g.V().outE().inV().path().by("name").by(label)
==>[marko,created,lop]
==>[marko,knows,vadas]
==>[marko,knows,josh]
==>[josh,created,ripple]
==>[josh,created,lop]
==>[peter,created,lop]
```
* as(label).select(Pop, label) - select values from previously labeled steps
```
gremlin> g.V(1).as("a").out("knows").as("a").select("a")
==>v[2]
==>v[4]

gremlin> g.V(1).as("a").out("knows").as("a").select(first, "a")
==>v[1]
==>v[1]

gremlin> g.V(1).as("a").out("knows").as("a").select(last, "a")
==>v[2]
==>v[4]

gremlin> g.V(1).as("a").out("knows").as("a").select(all, "a")
==>[v[1],v[2]]
==>[v[1],v[4]]
```
* `project`
```
gremlin> g.V().hasLabel("person").
    project("name", "label", "softwareName", "softwareLang").
    by("name").
    by(outE("created").label()).
    by(out("created").values("name")).
    by(out("created").values("lang"))
==>[name:marko,label:created,softwareName:lop,softwareLang:java]
==>[name:vadas]
==>[name:josh,label:created,softwareName:ripple,softwareLang:java]
==>[name:peter,label:created,softwareName:lop,softwareLang:java]

gremlin> g.V().hasLabel("person").as("person").
    out("created").as("sw").
    project("name", "label", "softwareName", "softwareLang").
    by(select("person").values("name")).
    by(select("person").outE("created").label()).
    by(select("sw").values("name")).
    by(select("sw").values("lang"))
==>[name:marko,label:created,softwareName:lop,softwareLang:java]
==>[name:josh,label:created,softwareName:ripple,softwareLang:java]
==>[name:josh,label:created,softwareName:lop,softwareLang:java]
==>[name:peter,label:created,softwareName:lop,softwareLang:java]

gremlin> g.V().hasLabel("person").as("person").
    out("created").as("sw").
    select("person").outE("created").label().as("edgeLabel").
    project("name", "label", "software", "softwareLang").
    by(select("person").values("name")).
    by(select("edgeLabel")).
    by(select("sw").values("name")).
    by(select("sw").values("name"))
==>[name:marko,label:created,software:lop,softwareLang:lop]
==>[name:josh,label:created,software:ripple,softwareLang:ripple]
==>[name:josh,label:created,software:ripple,softwareLang:ripple]
==>[name:josh,label:created,software:lop,softwareLang:lop]
==>[name:josh,label:created,software:lop,softwareLang:lop]
==>[name:peter,label:created,software:lop,softwareLang:lop]
```
* Update property of node
```
g.V(4192).property('name','Jim')
```
* Update property of node - also work with the Vertex directly and do
```
v = g.V(4192).next()
v.property('name','Jim')
```
* Update property of node - In case the `property()` method generates an array of values rather than updating the value, use `Cardinality`. This will replace the property value instead of appending into the list
```
g.V(4192)v.property(Cardinality.single, 'name', 'Jim').next()
```
* Update multiple properties at one
```
g.V(4192).property('name','John').property('age',30)
```
------
# Connect remote server
* Use below command to connect to remote server
```
:remote connect tinkerpop.server [yaml file path with connection details]
```
* Get currently connected server details
```
:remote current
```