http://localhost:7474
------

create(Raul: player{name: "Raul Vinci", pob: "Milan"}) create(It:County{name: "Italy"}) return Raul, It;

match(n) delete n

match(n) return n;

* Create relationship
create (Raul)-[r:PLAYER_OF]->(It)
return Raul, It
------
* Create a Relationship between existing Nodes
CREATE (Raul:player{name: "Raul Vinci", YOB: 1973, POB: "Milan"})   
CREATE (It:Country {name: "Itly"})  

MATCH (a:player), (b:Country) WHERE a.name = "Raul Vinci" AND b.name = "Itly"   
CREATE (a)-[r: FOOTBALLER_OF]->(b)   
RETURN a,b

match (Raul)-[r:FOOTBALLER_OF]->(It) delete r


create(Jack:person{name:"Jack", designation:"SE"}),(Jill:person{name:"Jill",designation:"SE2"}) return Jack, Jill
create(ADP:company{name:"ADP", location:"India"}) return ADP
match(a:person), (c:company) where a.name="Jill" and c.name="ADP" create (a)-[r:EMPLOYEES_OF]->(c)
match(b:person), (c:company) where b.name="Jack" and c.name="ADP" create (b)-[r:EMPLOYEES_OF]->(c)
match(a:company), (b:person) where a.name="ADP" and b.name="Jack" create (a)-[r:EMPLOYER_OF]->(b)
match(a:company), (b:person) where a.name="ADP" and b.name="Jill" create (a)-[r:EMPLOYER_OF]->(b)

MATCH p=()-[r:EMPLOYEES_OF]->() RETURN p LIMIT 25
MATCH p=()-[r:EMPLOYER_OF]->() RETURN p LIMIT 25
------
* Neo4j Delete a Relationship
match (Raul)-[r:PLAYER_OF]->(It) delete r

------
```
:play movie graph
```
------
```
:server status
```
---------------
// Get some data
MATCH (n1)-[r]->(n2) RETURN r, n1, n2 LIMIT 25

// Hello World!
CREATE (database:Database {name:"Neo4j"})-[r:SAYS]->(message:Message {name:"Hello World!"}) RETURN database, message, r

// Count all nodes
MATCH (n)
RETURN count(n)

// Count all relationships
MATCH ()-->() RETURN count(*);
