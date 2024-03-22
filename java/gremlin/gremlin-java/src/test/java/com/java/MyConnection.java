package com.java;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.ResultSet;

public class MyConnection {

    /** Stores/manages client connections **/
    private Cluster cluster;

    /** Connection to the graph db */
    private Client client;

    public MyConnection()
    {
        Cluster.Builder b = Cluster.build();
        b.addContactPoint("localhost");
        b.port(8182);
        this.cluster = b.create();
        this.client = cluster.connect();
    }

    public synchronized ResultSet queryGraph(String q)
    {
        return this.client.submit(q);
    }

    public void closeConnection()
    {
        this.cluster.close();
    }

}
