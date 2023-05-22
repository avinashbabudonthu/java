package com.java.resolver;

import com.java.data.loader.DataLoaderRegistryFactory;
import com.java.model.Address;
import com.java.model.Student7;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class Student7Resolver implements GraphQLResolver<Student7> {

    public CompletableFuture<Address> address(Student7 student7, DataFetchingEnvironment environment){
        DataLoader<Long, Address> dataLoader = environment.getDataLoader(DataLoaderRegistryFactory.ADDRESS_DATA_LOADER);
        return dataLoader.load(student7.getId());
    }

}