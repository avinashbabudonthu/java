package com.delete;

import com.mongodb.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Delete {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String COLLECTION_NAME = "employees";
    private static final String DB_NAME = "db1";

    @Test
    public void delete(){
        try(MongoClient mongoClient = new MongoClient(HOST, PORT)){
            DB db = mongoClient.getDB(DB_NAME);
            DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

            // where clause
            BasicDBObject whereClause = new BasicDBObject();
            whereClause.put("name", "e");

            WriteResult result = dbCollection.remove(whereClause);
            log.info("result={}", result);
        }
    }
}
