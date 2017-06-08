/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.cache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author gongbenkai
 */
@Data
@ConfigurationProperties(prefix = "cache")
public class CacheConfig {

    private Integer fast;
    private Integer slow;
    private Integer middle;

}
