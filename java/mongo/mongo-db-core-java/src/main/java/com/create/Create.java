package com.create;

import com.mongodb.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class Create {

    private static final String HOST = "localhost";
    private static final Integer PORT = 27017;
    private static final String COLLECTION_NAME="employees";
    private static final String DB_NAME = "db1";

    @Test
    public void save(){
        try(MongoClient mongoClient=new MongoClient(HOST, PORT)){
            DB db = mongoClient.getDB(DB_NAME);
            DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

            BasicDBObject basicDBObject = new BasicDBObject();
            basicDBObject.put("name", "jack");
            /*using LocalDate.now() throws following exception:
             org.bson.codecs.configuration.CodecConfigurationException:
             Can't find a codec for class java.time.LocalDate*/
            basicDBObject.put("joiningDate", new Date());
            basicDBObject.put("salary", 123455.56D);
            WriteResult result = dbCollection.save(basicDBObject);

            log.info("id=", result.getUpsertedId());
        }
    }

    @Test
    public void saveMultiple(){
        try(MongoClient mongoClient = new MongoClient(HOST, PORT)){
            DB db = mongoClient.getDB(DB_NAME);
            DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

            BasicDBObject document1 = new BasicDBObject();
            document1.put("name", "a");
            document1.put("joiningDate", new Date());
            document1.put("salary", 1000D);

            BasicDBObject document2 = new BasicDBObject();
            document2.put("name", "b");
            document2.put("joiningDate", new Date());
            document2.put("salary", 1100D);

            WriteResult result = dbCollection.insert(document1, document2);
            log.info("result={}", result);
        }
    }

    @Test
    public void saveMultipleWithList() {
        try (MongoClient mongoClient = new MongoClient(HOST, PORT)) {
            DB db = mongoClient.getDB(DB_NAME);
            DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

            BasicDBObject document1 = new BasicDBObject();
            document1.put("name", "c");
            document1.put("joiningDate", new Date());
            document1.put("salary", 1200D);

            BasicDBObject document2 = new BasicDBObject();
            document2.put("name", "d");
            document2.put("joiningDate", new Date());
            document2.put("salary", 1300D);

            List<BasicDBObject> documents = new ArrayList<>();
            documents.add(document1);
            documents.add(document2);

            WriteResult result = dbCollection.insert(documents);
            log.info("result={}", result);
        }
    }
}
