/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.netty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 *
 * @author gongbenkai
 */
public class NettyHttpChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        ChannelPipeline pipe = channel.pipeline();
        pipe.addLast(new ByteToMessageDecoder() {
            @Override
            protected void decode(ChannelHandlerContext chc, ByteBuf bb, List<Object> list) throws Exception {
                //To change body of generated methods, choose Tools | Templates.
            }
        });


    }

}
