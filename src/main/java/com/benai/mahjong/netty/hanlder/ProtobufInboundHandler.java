/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.netty.hanlder;

import com.benai.mahjong.event.handler.EventHandlerFactory;
import com.benai.mahjong.message.CommandBase.CommonMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gongbenkai
 */
public class ProtobufInboundHandler extends ChannelInboundHandlerAdapter {
    
    private final Logger logger = LoggerFactory.getLogger(ProtobufInboundHandler.class);
    
    IConContext gameEvent = new GameEvent();

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg == null || !(msg instanceof CommonMessage)) {
            logger.warn("message is null or message type is error");
            ctx.fireChannelRead(msg);
            return;
        } 
        // 根据cmd id找到相应的处理handler
        CommonMessage comMsg = (CommonMessage)msg;
        EventHandlerFactory.getHandlerByCmdId(comMsg.getCmdId()).doEvent(comMsg, gameEvent);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error("ChannelInboundHandler with error", cause);
        ctx.close();
    }
    
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        gameEvent.setChannelContext(ctx);
        super.channelRegistered(ctx);
    }
}
