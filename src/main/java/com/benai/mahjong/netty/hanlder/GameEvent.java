/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.netty.hanlder;

import com.benai.mahjong.player.IPlayer;
import io.netty.channel.ChannelHandlerContext;

/**
 *
 * @author gongbenkai
 */
public class GameEvent implements IConContext{
    ChannelHandlerContext channelContext;
    IPlayer player;

    @Override
    public void setChannelContext(ChannelHandlerContext ctx) {
        this.channelContext = ctx;
    }

    @Override
    public void setPlayer(IPlayer player) {
        this.player = player;
    }

    @Override
    public ChannelHandlerContext getChannelContext() {
        return this.channelContext;
    }

    @Override
    public IPlayer getPlayer() {
        return this.player;
    }
    
    
}
