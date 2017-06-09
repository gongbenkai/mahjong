/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.netty;


import com.benai.mahjong.netty.http.HttpServerInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 *
 * @author gongbenkai
 */
public class NettyHttpChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        ChannelPipeline pipe = channel.pipeline();
        // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
        pipe.addLast("encoder", new HttpResponseEncoder());
        // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
        pipe.addLast("decoder", new HttpRequestDecoder());
        pipe.addLast("aggregator", new HttpObjectAggregator(1048576));
        pipe.addLast("handler", new HttpServerInboundHandler());


    }

}
