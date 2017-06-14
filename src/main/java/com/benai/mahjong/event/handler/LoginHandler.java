/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.event.handler;

import com.benai.mahjong.message.CommandBase;
import com.benai.mahjong.netty.hanlder.IConContext;
import com.benai.mahjong.utils.RandomUtil;
import com.benai.mahjong.zookeeper.ZookeeperCli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gongbenkai
 */
@Component
public class LoginHandler implements IEventHandler{

    @Autowired
    ZookeeperCli zookeeperCli;
    
    @Override
    public void doEvent(CommandBase.CommonMessage msg, IConContext ctx) {
        switch (msg.getCmdId()) {
            case 1000:
                System.out.println("recivied cmd:" + msg.getCmdId());
                createRoom(msg, ctx);
                break;
            case 1001:
                System.out.println("recivied cmd:" + msg.getCmdId());
                break;
            default:
                break;
        }
    }

    // 创建房间
    private void createRoom(CommandBase.CommonMessage msg, IConContext ctx) {
        
        while (true) {
            String path = "/mahjong/room/" + RandomUtil.random6D();
            if (!zookeeperCli.isExists(path)) {
                zookeeperCli.createZNode(path, "{room}");
                break;
            }
        }
        
    }
    
    
    @Override
    public Integer[] getCmdids() {
        return new Integer[]{1000,10001};
    }
    
}
