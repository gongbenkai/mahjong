/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.room;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author gongbenkai
 */
@Component
@Scope("Singleton")
public class RoomContext implements IRoomContext {
    
    // 该服务器上所有房间列表
    private final Map<String, Room> rooms = new ConcurrentHashMap<>();
    
    
    @Override
    public Room addRoom(Room room) {
        if (room == null) {
            throw new NullPointerException("room");
        }
        rooms.put(room.getCode(), room);
        return room;
    }
    
    public Room getRoom(String code) {
        return rooms.get(code);
    }
}
