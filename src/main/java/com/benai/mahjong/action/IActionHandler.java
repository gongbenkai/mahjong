/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.action;

import com.benai.mahjong.card.BaseCard;
import java.util.Queue;
import com.benai.mahjong.room.IRoomContext;

/**
 *
 * @author gongbenkai
 */
public interface IActionHandler {
    
    IRoomContext getContext();
    IActionHandler next();
    void doAction(IRoomContext ctx, Queue<BaseCard> hasCards, BaseCard card);
}
