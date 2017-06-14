/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.event.handler;

import com.benai.mahjong.message.CommandBase;
import com.benai.mahjong.netty.hanlder.IConContext;

/**
 *
 * @author gongbenkai
 */
public interface IEventHandler {
    
    void doEvent(CommandBase.CommonMessage msg, IConContext ctx);
    Integer[] getCmdids();
}
