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
