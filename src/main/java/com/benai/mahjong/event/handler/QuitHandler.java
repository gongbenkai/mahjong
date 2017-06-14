/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.event.handler;

import com.benai.mahjong.message.CommandBase;
import com.benai.mahjong.netty.hanlder.IConContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author gongbenkai
 */
@Component
public class QuitHandler implements IEventHandler{

    @Override
    public void doEvent(CommandBase.CommonMessage msg, IConContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer[] getCmdids() {
        return new Integer[]{6000,60001};
    }
    
}
