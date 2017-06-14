/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.netty;

import com.benai.mahjong.message.CommandBase;
import com.benai.mahjong.netty.hanlder.ProtobufInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 *
 * @author gongbenkai
 */

public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {
    
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        ChannelPipeline pipe = channel.pipeline();
        pipe.addLast("frameDecoder", new ProtobufVarint32FrameDecoder());
        pipe.addLast("protobufDecoder", new ProtobufDecoder(CommandBase.CommonMessage.getDefaultInstance()));
        pipe.addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
        pipe.addLast("protobufEncoder", new ProtobufEncoder());
        pipe.addLast("handler", new ProtobufInboundHandler());

    }

}
