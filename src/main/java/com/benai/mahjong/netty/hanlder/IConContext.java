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
public interface IConContext {
    
    void setChannelContext(ChannelHandlerContext ctx);
    void setPlayer(IPlayer player);
    ChannelHandlerContext getChannelContext();
    IPlayer getPlayer();
}
