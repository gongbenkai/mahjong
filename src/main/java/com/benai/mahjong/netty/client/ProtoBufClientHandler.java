/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.netty.client;

import com.benai.mahjong.message.CommandBase;
import io.netty.channel.ChannelHandlerContext;  
import io.netty.channel.ChannelInboundHandlerAdapter;  
  
import java.util.ArrayList;  
import java.util.List;  

/**
 *
 * @author gongbenkai
 */
public class ProtoBufClientHandler extends ChannelInboundHandlerAdapter{
    
    @Override  
    public void channelActive(ChannelHandlerContext ctx) {  
        System.out.println("=======================================");  
//        CommandBase.CommonMessage.Builder builder = CommandBase.CommonMessage.newBuilder();  
//        builder.setCmdId(1000);  
// 
//        ctx.writeAndFlush(builder.build());
        ctx.fireChannelActive();
    }  
  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {  
        cause.printStackTrace();  
        ctx.close();  
    }  
}
