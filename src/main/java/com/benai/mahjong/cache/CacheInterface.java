/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.cache;

/**
 *
 * @author gongbenkai
 * @param <K>
 * @param <V>
 */
public interface CacheInterface<K,V> {
     V getKey(K key);
     void invalidate(Object key);
}
