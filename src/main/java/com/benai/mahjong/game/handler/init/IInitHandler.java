/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.game.handler.init;

import com.benai.mahjong.player.IPlayer;
import com.benai.mahjong.room.IRoom;

/**
 *
 * @author gongbenkai
 */
public interface IInitHandler {
    boolean doHandler(IRoom room, IPlayer player);
}
