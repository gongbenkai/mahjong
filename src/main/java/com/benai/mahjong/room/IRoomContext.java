/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.room;

/**
 *
 * @author gongbenkai
 */
public interface IRoomContext {
    
    Room addRoom(Room room);
    Room getRoom(String code);
}
