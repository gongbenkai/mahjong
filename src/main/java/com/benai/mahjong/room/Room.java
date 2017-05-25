/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.room;

import java.util.UUID;
import lombok.Data;

/**
 *
 * @author gongbenkai
 */
@Data
public class Room {
    
    private final String uuid;
    private final String code;
    
    public Room(String code) {
        this.uuid = UUID.randomUUID().toString();
        this.code = code;
    }
    
}
