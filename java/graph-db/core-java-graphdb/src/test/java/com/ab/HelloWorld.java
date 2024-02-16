package com.ab;

import lombok.extern.slf4j.Slf4j;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;

@Slf4j
public class HelloWorld {

    @Test
    void helloWorld() {
//        Graph graph = TinkerGraph.open();
//        TraversalSource traversalSource = graph.traversal();
//        List<Object> friends = g.V().has("name", "Alice").out().has("age", gt(30)).toList();

        GraphTraversalSource g = traversal().withRemote(DriverRemoteConnection.using("localhost", 8182, "g"));
        GraphTraversal<Vertex, Map<Object, Object>> list = g.V().elementMap();
        GraphTraversal<Vertex, Long> count = g.V().count();
        System.out.println(list.next());
        log.info("count={}", count);
    }

    @Test
    void method2() {
        GraphTraversalSource g = traversal().withRemote(DriverRemoteConnection.using("localhost", 8182, "g"));
        Vertex marko = g.V().has("person","name","marko").next();
        List<Vertex> peopleMarkoKnows = g.V().has("person","name","marko").out("knows").toList();
        log.info("peopleMarkoKnows={}", peopleMarkoKnows);
    }
}
