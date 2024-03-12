package com.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class HelloWorld {

    @Test
    void hello() throws Exception {
        GraphTraversalSource g = AnonymousTraversalSource.traversal().withRemote(DriverRemoteConnection.using("localhost", 8182));
//        log.info("g={}", g);
        GraphTraversal<Vertex, Map<Object, Object>> list = g.V().elementMap();
//        log.info("list={}", list);
        List<Map<Object, Object>> data = list.toStream().collect(Collectors.toList());
        log.info("data={}", data);
//        g.close();
    }

    @Test
    void hello2() {
        GraphTraversalSource g = AnonymousTraversalSource.traversal().withRemote(DriverRemoteConnection.using("localhost", 8182));
        Vertex v1 = g.addV("person").property("name","marko").next();
        Vertex v2 = g.addV("person").property("name","stephen").next();
        g.V(v1).addE("knows").to(v2).property("weight",0.75).iterate();
    }
}
