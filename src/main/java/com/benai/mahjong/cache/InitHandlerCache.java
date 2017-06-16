/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.cache;

import com.benai.mahjong.cache.config.CacheConfig;
import com.benai.mahjong.dao.mapper.HandlerMapper;
import com.benai.mahjong.game.handler.init.IInitHandler;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author gongbenkai
 */
@EnableConfigurationProperties(CacheConfig.class)
@Component
public class InitHandlerCache implements CacheInterface<Integer, IInitHandler> {

    private static final Logger log = LoggerFactory.getLogger(InitHandlerCache.class);

    LoadingCache<Integer, IInitHandler> cache;

    @Resource
    private CacheConfig cacheConfig;

    @Autowired
    private HandlerMapper handlerMapper;
    
    @Autowired
    private Map<String, IInitHandler> handlers;

    @PostConstruct
    public void init() {
        cache = CacheBuilder.newBuilder()
                .expireAfterAccess(cacheConfig.getSlow(), TimeUnit.MINUTES).maximumSize(200).removalListener(new RemovalListener<Object, Object>() {
            @Override
            public void onRemoval(RemovalNotification<Object, Object> notification) {
                log.info("get InitHandlerCache Listener {} was removed, cause is {} ", notification.getKey(), notification.getCause());
            }
        }).recordStats().build(new CacheLoader<Integer, IInitHandler>() {
            @Override
            public IInitHandler load(Integer key) throws ExecutionException {

                try {
                    return handlers.get(handlerMapper.getInitHandler(key));
                } catch (Exception ex) {
                    log.error("get InitHandlerCache load error {}", ex);
                }
                return null;
            }
        });
    }

    @Override
    public IInitHandler getKey(Integer key) {
        try {
            return cache.get(key);
        } catch (Exception ex) {
            log.error("get InitHandlerCache not find data {}", ex);
            return null;
        }
    }

    @Override
    public void invalidate(Object key) {
        cache.invalidate(key);
    }

}
