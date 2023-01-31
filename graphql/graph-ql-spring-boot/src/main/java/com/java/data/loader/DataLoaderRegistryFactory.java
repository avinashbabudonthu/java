package com.java.data.loader;

import com.java.context.CustomGraphQLContext;
import com.java.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class DataLoaderRegistryFactory {

    public static final String ADDRESS_DATA_LOADER = "ADDRESS_DATA_LOADER";
    private static final Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public DataLoaderRegistry create() {
        DataLoaderRegistry dataLoaderRegistry = new DataLoaderRegistry();

        // dataLoaderRegistry.register(ADDRESS_DATA_LOADER, getAddress());

        // To user any header
        dataLoaderRegistry.register(ADDRESS_DATA_LOADER, getAddressV2());

        return dataLoaderRegistry;
    }

    public DataLoader<Long, Address> getAddress() {
        return DataLoader.newMappedDataLoader((Set<Long> studentIds, BatchLoaderEnvironment environment) ->
                        CompletableFuture.supplyAsync(() -> getAddress1(studentIds), executor),
                new DataLoaderOptions().setBatchLoaderContextProvider(() -> {
                    return "this is the context";
                })
        );
    }

    public DataLoader<Long, Address> getAddressV2() {
        return DataLoader.newMappedDataLoader((Set<Long> studentIds, BatchLoaderEnvironment environment) -> {
                    String context = environment.getContext();
                    log.info("context={}", context);

                    return CompletableFuture.supplyAsync(() -> getAddress1(studentIds), executor);
                },
                new DataLoaderOptions().setBatchLoaderContextProvider(() -> {
                    return "this is the context";
                })
        );
    }

    @NotNull
    private Map<Long, Address> getAddress1(Set<Long> studentIds) {
        log.info("Requesting student ids={}", studentIds);
        Map<Long, Address> map = new HashMap<>();

        for (Long studentId : studentIds) {
            Address address = Address.builder()
                    .hNo(String.valueOf(studentId))
                    .street("street")
                    .city("city")
                    .build();

            map.put(studentId, address);
        }

        return map;
    }
}
