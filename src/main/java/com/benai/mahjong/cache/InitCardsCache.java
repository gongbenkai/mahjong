/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.cache;

import com.benai.mahjong.cache.config.CacheConfig;
import com.benai.mahjong.card.BaseCard;
import com.benai.mahjong.dao.mapper.CardMapper;
import com.benai.mahjong.netty.config.ServerConfig;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.List;
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
@Component("initCardsCache")
public class InitCardsCache implements CacheInterface<Integer, List<BaseCard>> {

    private static final Logger log = LoggerFactory.getLogger(InitCardsCache.class);

    LoadingCache<Integer, List<BaseCard>> activetyCache;

    @Resource
    private CacheConfig cacheConfig;

    @Autowired
    CardMapper cardMapper;

    @PostConstruct
    public void init() {
        activetyCache = CacheBuilder.newBuilder()
                .expireAfterWrite(cacheConfig.getSlow(), TimeUnit.MINUTES).maximumSize(20).removalListener(new RemovalListener<Object, Object>() {
            @Override
            public void onRemoval(RemovalNotification<Object, Object> notification) {
                log.info("get InitCardsCache Listener {} was removed, cause is {} ", notification.getKey(), notification.getCause());
            }
        }).recordStats().build(new CacheLoader<Integer, List<BaseCard>>() {
            @Override
            public List<BaseCard> load(Integer key) throws ExecutionException {

                try {
                    return cardMapper.getInitCardsByCode(key);
                } catch (Exception ex) {
                    log.error("get InitCardsCache load error {}", ex);
                }
                return null;
            }
        });
    }

    @Override
    public List<BaseCard> getKey(Integer key) {
        try {
            return activetyCache.get(key);
        } catch (Exception ex) {
            log.error("get InitCardsCache not find data {}", ex);
            return null;
        }
    }

    @Override
    public void invalidate(Object key) {
        activetyCache.invalidate(key);
    }

}
