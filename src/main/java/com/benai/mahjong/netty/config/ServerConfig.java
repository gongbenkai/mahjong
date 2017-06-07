/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.netty.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author gongbenkai
 */
@ConfigurationProperties(prefix = "server")
public class ServerConfig {

    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
