/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.executor;

import com.benai.mahjong.executor.config.ExecutorConfig;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author gongbenkai
 */
@EnableConfigurationProperties(ExecutorConfig.class)
@Component("initExecutor")
public class InitExecutor implements IExecutor{
    
    ExecutorService executor;
    
    @Resource
    private ExecutorConfig executorConfig;
    
    @PostConstruct
    public void init() {
        if (executorConfig.getInitThreads() != null && executorConfig.getInitThreads() > 0) {
            executor = Executors.newFixedThreadPool(executorConfig.getInitThreads());
        } else {
            executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 3 + 1);
        }
        
    }

    @Override
    public Object excutor(Object p) {
//        FutureTask<String> future =　executor.submit(   
//   new Callable<String>() {//使用Callable接口作为构造参数   
//       public String call() {   
//      //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型   
//  }}); 
return null;
    }
    
}
