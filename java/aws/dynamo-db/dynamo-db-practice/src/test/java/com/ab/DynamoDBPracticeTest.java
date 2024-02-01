package com.ab;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

@SuppressWarnings("all")
public class DynamoDBPracticeTest {

    @Test
    void createTable() {
        AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBAsyncClient().withEndpoint("http://localhost:8000");

        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDBClient);
        String tableName = "student_0001";
        try {
            System.out.println("Creating table");
            Table table = dynamoDB.createTable(tableName,
                    List.of(
                            new KeySchemaElement("ID", KeyType.HASH),
                            new KeySchemaElement("firstName", KeyType.RANGE)
                    ),
                    List.of(
                            new AttributeDefinition("ID", ScalarAttributeType.N),
                            new AttributeDefinition("firstName", ScalarAttributeType.S)
                    ),
                    new ProvisionedThroughput(10L, 10L)
                    );
            table.waitForActive();

            System.out.println("Created table. status = " + table.getDescription().getTableStatus());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
