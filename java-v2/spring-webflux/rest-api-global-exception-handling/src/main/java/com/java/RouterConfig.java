package com.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routeFunction() {
        return RouterFunctions
                .route(RequestPredicates.GET("/api1"), this::resourceNotFound)
                .andRoute(RequestPredicates.GET("/api2"), this::badRequest);
    }

    private RouterFunction<ServerResponse> errorRoutes() {
        return RouterFunctions.route()
                .onError(ResourceNotFoundException.class, this::handleResourceNotFoundException)
                .onError(BadRequestException.class, this::handleBadRequestException)
                .onError(Exception.class, this::handleGenericException)
                .build();
    }

    public Mono<ServerResponse> resourceNotFound(ServerRequest serverRequest) {
        return Mono.error(new ResourceNotFoundException("Resource not found"));
    }

    public Mono<ServerResponse> badRequest(ServerRequest serverRequest) {
        return Mono.error(new BadRequestException("Bad request"));
    }

    private Mono<ServerResponse> handleResourceNotFoundException(Throwable throwable, ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.TEXT_PLAIN)
                .bodyValue(throwable.getMessage());
    }

    private Mono<ServerResponse> handleBadRequestException(Throwable throwable, ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.TEXT_PLAIN)
                .bodyValue(throwable.getMessage());
    }

    private Mono<ServerResponse> handleGenericException(Throwable throwable, ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.TEXT_PLAIN)
                .bodyValue(throwable.getMessage());
    }

}