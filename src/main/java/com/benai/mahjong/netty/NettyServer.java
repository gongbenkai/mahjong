package com.benai.mahjong.netty;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.benai.mahjong.netty.config.ServerConfig;


@Component
@EnableConfigurationProperties(ServerConfig.class)
public class NettyServer { //implements ApplicationContextAware 

    private final Logger log = LoggerFactory.getLogger(NettyServer.class);

    private final EventLoopGroup masters = new NioEventLoopGroup();

    private final EventLoopGroup workers = new NioEventLoopGroup();

//    private final EventLoopGroup httpMasters = new NioEventLoopGroup(1);
//
//    private final EventLoopGroup httpWorkers = new NioEventLoopGroup(2);

    @Resource
    private ServerConfig serverConfig;

    private static ApplicationContext ctx;
    
//    @Autowired
//    NettyHttpChannelInitializer nettyHttpChannelInitializer;
    

    @PostConstruct
    public void start() {

        try {
            ServerBootstrap bootstrap = new ServerBootstrap().group(masters, workers);
            bootstrap = bootstrap.channel(NioServerSocketChannel.class);
//        bootstrap = bootstrap.option(ChannelOption.SO_BACKLOG, serverConfig.getBacklog());
//        bootstrap = bootstrap.option(ChannelOption.TCP_NODELAY, serverConfig.isNodelay());
//        bootstrap = bootstrap.option(ChannelOption.SO_KEEPALIVE, serverConfig.isKeepAlive());
            bootstrap.childHandler(new NettyChannelInitializer());
            ChannelFuture future = bootstrap.bind(Integer.valueOf(serverConfig.getPort())).sync();
            log.info("Netty Server started......");

//            ServerBootstrap httpBootstrap = new ServerBootstrap().group(httpMasters, httpWorkers);
//            httpBootstrap = httpBootstrap.channel(NioServerSocketChannel.class);
////        bootstrap = bootstrap.option(ChannelOption.SO_BACKLOG, serverConfig.getBacklog());
////        bootstrap = bootstrap.option(ChannelOption.TCP_NODELAY, serverConfig.isNodelay());
////        bootstrap = bootstrap.option(ChannelOption.SO_KEEPALIVE, serverConfig.isKeepAlive());
//            httpBootstrap.childHandler(nettyHttpChannelInitializer);
//            ChannelFuture httpFuture = httpBootstrap.bind(Integer.valueOf(serverConfig.getHttpPort())).sync();
//            log.info("Netty http Server started......");

            future.channel().closeFuture().sync();
//            httpFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stop();
        }

    }

    @PreDestroy
    public void stop() {

        workers.shutdownGracefully();
        masters.shutdownGracefully();
//
//        httpWorkers.shutdownGracefully();
//        httpMasters.shutdownGracefully();

    }

//    @Override
//    public void setApplicationContext(ApplicationContext ctx)
//            throws BeansException {
//        NettyServer.ctx = ctx;
//        String[] all = ctx.getBeanNamesForAnnotation(Component.class);
//        for (String n : all) {
//            log.info(n);
//        }
////        log.info(getBean("ifpControlProcessor").getClass().getName());
//    }

    public static Object getBean(String id) {
        return ctx.getBean(id);
    }

}
