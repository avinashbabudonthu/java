package com.update;

import com.mongodb.*;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Update {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String COLLECTION_NAME = "employees";
    private static final String DB_NAME = "db1";

    @Test
    public void update(){
        try(MongoClient mongoClient = new MongoClient(HOST, PORT)){
            DB db = mongoClient.getDB(DB_NAME);
            DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

            // where condition
            BasicDBObject whereClause = new BasicDBObject();
            whereClause.put("name", "jack");

            // new value
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("name", "e");

            // set command
            BasicDBObject updateQuery = new BasicDBObject();
            updateQuery.put("$set", newDocument);

            WriteResult result = dbCollection.update(whereClause, updateQuery);
            log.info("result={}", result);
        }
    }
}
