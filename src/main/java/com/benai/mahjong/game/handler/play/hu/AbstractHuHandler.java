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
public class AbstractHuHandler implements IHuHandler{
    
    private IHuHandler next;
    
    @Override
    public void doEvent(List<ICard> cards, IPlayer player, IRoom room) {
        fireEvent(cards, player, room);
    }
    
    
    @Override
    public void fireEvent(List<ICard> cards, IPlayer player, IRoom room) {
        if (this.next != null) {
            next.doEvent(cards, player, room);
        }
    }
    
}
