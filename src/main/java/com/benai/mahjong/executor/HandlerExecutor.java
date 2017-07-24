/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.executor;

import com.benai.mahjong.executor.config.ExecutorConfig;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author gongbenkai
 */
@Component
@EnableConfigurationProperties(ExecutorConfig.class)
public class HandlerExecutor implements IHandlerExecutor{
    
    Executor executor;
    
    @Resource
    private ExecutorConfig executorConfig;
    
    @PostConstruct
    public void init() {
        if (executorConfig.getInitThreads() != null && executorConfig.getInitThreads() > 0) {
            executor = Executors.newFixedThreadPool(executorConfig.getInitThreads());
        } else {
            executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        }    
        
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }

    
}
