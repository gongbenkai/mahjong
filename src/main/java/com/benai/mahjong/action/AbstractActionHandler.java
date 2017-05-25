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
public abstract class AbstractActionHandler implements ActionHandler{
    private RoomContext ctx;
    private ActionHandler next;
    
    @Override
    public RoomContext getContext() {
        if (this.ctx == null) {
            throw new NullPointerException("RoomContext");
        }
        return this.ctx;
    }
    
    @Override
    public ActionHandler next() {
        return this.next;
    }
    
    @Override
    public void doAction(RoomContext ctx, Queue<BaseCard> hasCards, BaseCard card) {
        fireAction(ctx, hasCards, card);
    }
    
    public void fireAction(RoomContext ctx, Queue<BaseCard> hasCards, BaseCard card) {
        if (this.next != null) {
            this.next.doAction(ctx, hasCards, card);
        }
    }
    
}
