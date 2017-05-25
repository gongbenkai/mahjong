/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.action;

import com.benai.mahjong.card.BaseCard;
import com.benai.mahjong.room.RoomContext;
import java.util.Queue;

/**
 *
 * @author gongbenkai
 */
public interface ActionHandler {
    
    RoomContext getContext();
    ActionHandler next();
    void doAction(RoomContext ctx, Queue<BaseCard> hasCards, BaseCard card);
}
