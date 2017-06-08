/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.netty.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author gongbenkai
 */
@Data
@ConfigurationProperties(prefix = "server")
public class ServerConfig {

    private String port;
    private String httpPort;


}
