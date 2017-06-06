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
public abstract class AbstractActionHandler implements IActionHandler{
    private IRoomContext ctx;
    private IActionHandler next;
    
    @Override
    public IRoomContext getContext() {
        if (this.ctx == null) {
            throw new NullPointerException("RoomContext");
        }
        return this.ctx;
    }
    
    @Override
    public IActionHandler next() {
        return this.next;
    }
    
    @Override
    public void doAction(IRoomContext ctx, Queue<BaseCard> hasCards, BaseCard card) {
        fireAction(ctx, hasCards, card);
    }
    
    public void fireAction(IRoomContext ctx, Queue<BaseCard> hasCards, BaseCard card) {
        if (this.next != null) {
            this.next.doAction(ctx, hasCards, card);
        }
    }
    
}
