/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.zookeeper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author gongbenkai
 */
@Data
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperConfig {

    private String server;

}
