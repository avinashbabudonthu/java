# Create Nodes
* create single node
```
create(node1)
```
* create multiple nodes:
```
create(node1), (node2), (node3), (node4)
```
* create single node with 1 label:
```
syntax: create(node:label)
create(Kalam:Scientist)
```
* create single node with multiple labels:
```
syntax: create(node:label1:label2:..labeln)
create(kalam:person:scientist:president)
```
* create node with properties:
```
syntax: CREATE (node:label { key1: value, key2: value, . . . . . . . . .  })   
create(ana:developer:scrumMaster{designation: "SE", qualification: "BTech", doj: "08/23/2000"})
create(jill:developer:scrumMaster{name:"jill", designation: "SE", qualification: "BTech", doj: "08/23/2000"})
create(mill:developer{name:"mill", designation: "SE", doj: "08/23/2000"})
CREATE(Ajeet:Developer{name: "Ajeet Kumar", YOB: 1989, POB: "Mau"})
create(mill:developer{name:"miller", designation: "SE", doj: "08/23/2000"})
```
* return the created node:
```
syntax - CREATE (Node:Label{properties. . . . }) RETURN Node
CREATE (Sonoo:trainer{name: "Sonoo Jaiswal", YOB: 1987, POB: "Faizabad"}) RETURN Sonoo
```
------
# Delete
* delete all nodes
```
match(n) delete n
```
* Delete Relationship
```
match (Raul)-[r:PLAYER_OF]->(It) delete r
```
* detach node from all relationships and delete
```
match(a:person{name: "Jack"}) detach delete a
match(a:person{name: "Jill"}) detach delete a
```
------
# Select
* get all nodes
```
match(n) return n;
```
* Get 25 nodes with matching relationship
```
MATCH p=()-[r:EMPLOYEES_OF]->() RETURN p LIMIT 25
MATCH p=()-[r:EMPLOYER_OF]->() RETURN p LIMIT 25
```
* Get some data
```
MATCH (n1)-[r]->(n2) RETURN r, n1, n2 LIMIT 25
```
* Count all nodes
```
MATCH (n) RETURN count(n)
```
* Count all relationships
```
MATCH ()-->() RETURN count(*);
```
* get node with name equals to Node1: both below queries are same
```
match(n1: label1) where n1.name="Node1" return n1
match(n1: label1{name: "Node1"}) return n1
```
* order by:
```
MATCH (n)    
RETURN n.name, n.Marks   
ORDER BY n.Marks
```
* Order Nodes by Multiple Properties:
```
MATCH (n)   
RETURN n   
ORDER BY n.property_1, n.property_2 

MATCH (n)   
RETURN n.name, n.Marks, n.country   
ORDER BY n.name, n.Marks
```
* Order Nodes in Descending Order
```
MATCH (n)   
RETURN n   
ORDER BY n.property DESC   

MATCH (n)    
RETURN n.name, n.Marks   
ORDER BY n.Marks DESC  
```
* LIMIT Clause:
```
MATCH (n)   
RETURN n   
ORDER BY n.name   
LIMIT i 

MATCH (n) RETURN n.name, n.Marks ORDER BY n.Marks DESC LIMIT 3 

match(n) return n order by n.name desc limit 2  
```
* LIMIT with Expression
```
MATCH (n)   
RETURN n.name, n.Marks   
ORDER BY n.Marks DESC   
LIMIT toInt(3 * rand())+ 1   
```
* following query counts and returns the number of nodes participating in each relation:
```
Match(n)-[r]-(x) RETURN (r), count(*)
```
------
# Others
* Play movie graph
```
:play movie graph
```
```
:server status
```
* Hello World!
```
CREATE (database:Database {name:"Neo4j"})-[r:SAYS]->(message:Message {name:"Hello World!"}) RETURN database, message, r
```
------
* Creating a complete path:
```
CREATE p = (Node1 {properties})-[:Relationship_Type]->  
(Node2 {properties})[:Relationship_Type]->(Node3 {properties})   
RETURN p

CREATE p = (Kohli {name:"Virat Kohli"})-[:TOPSCORRER_OF]->  
(Ind {name: "India"})-[: WINNER_OF]->(Node3 {CT: "Champions_Trophy"})   
RETURN p
```
------
# Practice nodes scripts
* Create nodes
```
create(node1:label1{name: "Node1"}) return node1
create(node2:label1{name: "Node2"}) return node2
create(node3:label1{name: "Node3"}) return node3
create(node4:label1{name: "Node4"}) return node4
create(node5:label1{name: "Node5"}) return node5
```
* create relation1 from node1 to node2
```
match(a:label1),(b:label1) where a.name="Node1" and b.name="Node2"
create (a)-[r:relation1]->(b)
return a,b
```
* create relationship with label and properties
```
syntax: CREATE (node1)-[label:Rel_Type {key1:value1, key2:value2, . . . n}]-> (node2) 
example:
match(a:label1), (b:label1) where a.name="Node2" and b.name="Node3"
create (a)-[rel:relation2{from: "Node2", to: "Node3"}]->(b)
return a,b
```
* Query by id
```
MATCH (s)
WHERE ID(s) = 65110
RETURN s
```
------
## Fundamentals
Store any kind of data using the following graph concepts:

* **Node**: Graph data records
* **Relationship**: Connect nodes (has direction and a type)
* **Property**: Stores data in key-value pair in nodes and relationships
* **Label**: Groups nodes and relationships (optional)

---

## Browser editor

### CLI

Examples: `:help` `:clear`

---

# Cypher

## Match

### Match node

```cypher
MATCH (ee:Person)
WHERE ee.name = "Emil"
RETURN ee;
```

* **MATCH** clause to specify a pattern of nodes and relationships
* **(ee:Person)** a single node pattern with label 'Person' which will assign matches to the variable `ee`
* **WHERE** clause to constrain the results
* **ee.name = "Emil"** compares name property to the value "Emil"
* **RETURN** clause used to request particular results

Gets gets the id<5> and id<0> nodes and creates a `:KNOWS` relationship between them

### Match nodes and relationships

```cypher
MATCH (ee:Person)-[:KNOWS]-(friends)
WHERE ee.name = "Emil"
RETURN ee, friends
```

* **MATCH** clause to describe the pattern from known Nodes to found Nodes
* **(ee)** starts the pattern with a Person (qualified by WHERE)
* **-[:KNOWS]-** matches "KNOWS" relationships (in either direction)
* **(friends)** will be bound to Emil's friends

### Match labels

```cypher
MATCH (n:Person)
RETURN n
```

or

```cypher
MATCH (n)
WHERE n:Person
RETURN n
```

### Match multiple labels

`:Car` **OR** `:Person` labels

```cypher
MATCH (n)
WHERE n:Person OR n:Car
RETURN n
```

`:Car` **AND** `:Person` labels

```cypher
MATCH (n)
WHERE n:Person:Car
RETURN n
```

### Match same properties

```cypher
MATCH (a:Person)
WHERE a.from = "Sweden"
RETURN a
```

Returns every node (and their relationships) where there's a property `from` with "Sweden" value

### Match friends of friends with same hobbies

Johan is learning surfing, and wants to know any friend of his friends who already knows surfing

```cypher
MATCH (js:Person)-[:KNOWS]-()-[:KNOWS]-(surfer)
WHERE js.name = "Johan" AND surfer.hobby = "surfing"
RETURN DISTINCT surfer
```

* **()** empty parenthesis to ignore these nodes
* **DISTINCT** because more than one path will match the pattern
* **surfer** will contain Allison, a friend of a friend who surfs

### Match by ID

Every node and relationship has an internal autonumeric ID, which can be queried using **<**, **<=**, **=**, **=>**, **<>** and **IN** operators:

**Search node by ID**

```cypher
MATCH (n)
WHERE id(n) = 0
RETURN n
```

**Search multiple nodes by ID**

```cypher
MATCH (n)
WHERE id(n) IN [1, 2, 3]
RETURN n
```

**Search relationship by ID**

```cypher
MATCH ()-[n]-()
WHERE id(n) = 0
RETURN n
```

---

## Create

### Create node

```cypher
CREATE (ee:Person { name: "Emil", from: "Sweden", klout: 99 })
```

* **CREATE** clause to create data
* **()** parenthesis to indicate a node
* **ee:Person** a variable `ee` and label `Person` for the new node
* **{}** brackets to add properties (key-value pairs) to the node

### Create nodes and relationships

```cypher
MATCH (ee:Person) WHERE ee.name = "Emil"
CREATE (js:Person { name: "Johan", from: "Sweden", learn: "surfing" }),
(ir:Person { name: "Ian", from: "England", title: "author" }),
(rvb:Person { name: "Rik", from: "Belgium", pet: "Orval" }),
(ally:Person { name: "Allison", from: "California", hobby: "surfing" }),
(ee)-[:KNOWS {since: 2001}]->(js),(ee)-[:KNOWS {rating: 5}]->(ir),
(js)-[:KNOWS]->(ir),(js)-[:KNOWS]->(rvb),
(ir)-[:KNOWS]->(js),(ir)-[:KNOWS]->(ally),
(rvb)-[:KNOWS]->(ally)
```

* **MATCH** clause to get "Emil" in `ee` variable
* **CREATE** clause to create multiple nodes (comma separated) with their labels and properties. Also creates directed relationships `(a)-[:Label {key: value}]->(b)`

### Create relationship between 2 unrelated nodes

```cypher
MATCH (n), (m)
WHERE n.name = "Allison" AND m.name = "Emil"
CREATE (n)-[:KNOWS]->(m)
```

Alternative with `MERGE`, which ensures that the relationship is created only **once**

```cypher
MATCH (n:User {name: "Allison"}), (m:User {name: "Emil"})
MERGE (n)-[:KNOWS]->(m)
```

### Create node with multiple labels

```cypher
CREATE (n:Actor:Director)
```

---

## Update

### Update node properties (add new or modify)

Add new `.owns` property or modify (if exists)

```cypher
MATCH (n)
WHERE n.name = "Rik"
SET n.owns = "Audi"
```

### Replace all node properties for the new ones

**Danger**: It will delete all previous properties and create `.plays` and `.age` properties

```cypher
MATCH (n)
WHERE n.name = "Rik"
SET n = {plays: "Piano", age: 23}
```

### Add new node properties without deleting old ones

**Danger**: If `.plays` or `.age` properties are already set, it will overwrite them

```cypher
MATCH (n)
WHERE n.name = "Rik"
SET n += {plays: "Piano", age: 23}
```

### Add new node property if property not already set

```cypher
MATCH (n)
WHERE n.plays = "Guitar" AND NOT (EXISTS (n.likes))
SET n.likes = "Movies"
```

### Rename a property in all nodes

```cypher
MATCH (n)
WHERE NOT (EXISTS (n.instrument))
SET n.instrument = n.plays
REMOVE n.plays
```

Alternative

```cypher
MATCH (n)
WHERE n.instrument is null
SET n.instrument = n.plays
REMOVE n.plays
```

### Add label to existing node

Adds the `:Food` label to nodes id<7> and id<8>

```cypher
MATCH (n)
WHERE id(n) IN [7, 8]
SET n:Food
```

### Creates the node if not exists and updates (or creates) a property

```cypher
MERGE (n:Person {name: "Rik"})
SET n.owns = "Audi"
```

---

## Delete

### Delete nodes

To **delete a node** (p.e. id<5>), first we need to **delete its relationships**. Then, the node can be deleted

```cypher
MATCH (n)-[r]-()
WHERE id(n) = 5
DELETE r, n
```

To **delete multiple nodes** (must have their relationships previously deleted)

```cypher
MATCH (n)
WHERE id(n) IN [1, 2, 3]
DELETE n
```


### Deletes a property in a specific node

```cypher
MATCH (n)
WHERE n:Person AND n.name = "Rik" AND n.plays is NOT null
REMOVE n.plays
```

Alternative

```cypher
MATCH (n)
WHERE n:Person AND n.name = "Rik" AND EXISTS (n.plays)
REMOVE n.plays
```


### Delete a label from all nodes

Deletes the `:Person` label from **all** nodes

```cypher
MATCH (n)
REMOVE n:Person
```

### Delete a label from nodes with specific labels

Deletes the `:Person` label from nodes with `:Food` and `:Person` labels

```cypher
MATCH (n)
WHERE n:Food:Person
REMOVE n:Person
```

### Delete multiple labels from nodes

Deletes the `:Food` and `:Person` labels from nodes which have **both** labels

```cypher
MATCH (n)
WHERE n:Food:Person
REMOVE n:Food:Person
```

**Danger**: Deletes the `:Food` and `:Person` labels from nodes which have `:Food` or `:Person` or `:Food:Person` labels

```cypher
MATCH (n)
REMOVE n:Food:Person
```

### Delete entire database

```cypher
MATCH (n)
OPTIONAL MATCH (n)-[r]-()
DELETE n, r
```

---

## Other clauses

### Show execution plan

Use `PROFILE` or `EXPLAIN` before the query

`PROFILE`: Shows the execution plan, query information and **db hits**. Example: Cypher version: CYPHER 3.0, planner: COST, runtime: INTERPRETED. 84 total db hits in 32 ms.

`EXPLAIN`: Shows the execution plan and query information. Example: Cypher version: CYPHER 3.0, planner: COST, runtime: INTERPRETED.

### Count

Count all nodes

```cypher
MATCH (n)
RETURN count(n)
```

Count all relationships

```cypher
MATCH ()-->()
RETURN count(*);
```

### Limit

Returns up to 2 nodes (and their relationships) where there's a property `from` with "Sweden" value

```cypher
MATCH (a:Person)
WHERE a.from = "Sweden"
RETURN a
LIMIT 2
```

### Create unique property constraint

Make `.name` property unique on nodes with `:Person` label

```cypher
CREATE CONSTRAINT ON (n:Person)
ASSERT n.name IS UNIQUE
```

### Drop unique property constraint

Make `.name` property unique on nodes with `:Person` label

```cypher
DROP CONSTRAINT ON (n:Person)
ASSERT n.name IS UNIQUE
```
* Get all relationships
```
return ()-->()
```
