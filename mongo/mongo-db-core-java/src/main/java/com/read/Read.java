package com.read;

import com.mongodb.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Read {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String COLLECTION_NAME = "employees";
    private static final String DB_NAME = "db1";

    @Test
    public void find(){
        try(MongoClient mongoClient = new MongoClient(HOST, PORT)){
            DB db = mongoClient.getDB(DB_NAME);
            DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

            // where condition
            BasicDBObject whereClause = new BasicDBObject();
            whereClause.put("name", "a");

            DBCursor cursor = dbCollection.find(whereClause);
            while(cursor.hasNext()){
                log.info("document={}", cursor.next());
            }
        }
    }

}
