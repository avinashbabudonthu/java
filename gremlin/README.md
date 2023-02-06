# Gremlin Console
* Download gremlin console - https://www.apache.org/dyn/closer.lua/tinkerpop/3.6.1/apache-tinkerpop-gremlin-console-3.6.1-bin.zip
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
* Count vertices
```
g.V().count()
```
* All vertices
```
g.V()
```
* Exit
```
:exit
```
* Gremlin console docker container - https://hub.docker.com/r/tinkerpop/gremlin-console