package com.java.instrumentation;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.execution.ExecutionId;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.SimpleInstrumentationContext;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class RequestLoggingInstrumentation extends SimpleInstrumentation {

    private static final String CORRELATION_ID = "correlation_id";

    public InstrumentationContext<ExecutionResult> beginExecution(InstrumentationExecutionParameters parameters) {
        // return beginExecutionV1(parameters);
        return beginExecutionWithMDC(parameters);
    }

    @NotNull
    private SimpleInstrumentationContext<ExecutionResult> beginExecutionV1(InstrumentationExecutionParameters parameters) {
        long startTime = System.currentTimeMillis();

        ExecutionInput executionInput = parameters.getExecutionInput();
        ExecutionId executionId = executionInput.getExecutionId();

        String query = parameters.getQuery();
        Map<String, Object> variables = parameters.getVariables();

        log.info("executionId={}, query={}, variables={}", executionId, query, variables);

        return SimpleInstrumentationContext.whenCompleted(((ExecutionResult executionResult, Throwable throwable) -> {
            long endTime = System.currentTimeMillis();
            if(null == throwable){
                log.info("executionId={} completed successfully. time={} ms", executionId, (endTime-startTime));
            }else{
                log.info("executionId={} failed. time={} ms", executionId, (endTime-startTime));
            }
        }));
    }

    /**
     * If we need to include executionId/correlationId in every log message
     * @param parameters
     * @return
     */
    @NotNull
    private SimpleInstrumentationContext<ExecutionResult> beginExecutionWithMDC(InstrumentationExecutionParameters parameters) {
        long startTime = System.currentTimeMillis();

        ExecutionInput executionInput = parameters.getExecutionInput();
        ExecutionId executionId = executionInput.getExecutionId();

        MDC.put(CORRELATION_ID, executionId.toString());

        String query = parameters.getQuery();
        Map<String, Object> variables = parameters.getVariables();

        log.info("query={}, variables={}", query, variables);

        return SimpleInstrumentationContext.whenCompleted(((ExecutionResult executionResult, Throwable throwable) -> {
            long endTime = System.currentTimeMillis();
            if(null == throwable){
                log.info("completed successfully. time={} ms", (endTime-startTime));
            }else{
                log.info("failed. time={} ms", (endTime-startTime));
            }
            MDC.clear();
        }));
    }


}
