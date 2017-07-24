/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.game.handler.play.hu;

import com.benai.mahjong.card.ICard;
import com.benai.mahjong.player.IPlayer;
import com.benai.mahjong.room.IRoom;
import java.util.List;

/**
 *
 * @author gongbenkai
 */
public interface IHuHandler {
    
    void doEvent(List<ICard> cards, IPlayer player, IRoom room);
    void fireEvent(List<ICard> cards, IPlayer player, IRoom room);
    
}
