package com.swathiprasad.customer;

import io.micrometer.context.ContextExecutorService;
import io.micrometer.context.ContextSnapshot;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration(proxyBeanMethods = false)
public class AsyncTraceContextConfig implements AsyncConfigurer {

    private final ThreadPoolTaskExecutor taskExecutor;

    AsyncTraceContextConfig(ThreadPoolTaskExecutor taskExecutor){
        this.taskExecutor = taskExecutor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return ContextExecutorService.wrap(
                taskExecutor.getThreadPoolExecutor(), ContextSnapshot::captureAll);
    }

}
