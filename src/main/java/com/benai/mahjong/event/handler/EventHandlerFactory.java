/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.event.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gongbenkai
 */
@Component
public class EventHandlerFactory  { 

    private static final Map<Integer, IEventHandler> handlerMaps = new HashMap<>();
    
    @Autowired
    private List<IEventHandler> handlers;


    @PostConstruct
    public void init() {
        // 根据handler包含的cmd id，对应出每个cmd对应的handler
        handlers.stream().forEach((IEventHandler handler) -> {
            for(Integer cmdId : handler.getCmdids()) {
                handlerMaps.put(cmdId, handler);
            }
        });

    }
    
    public static IEventHandler getHandlerByCmdId(Integer cmdId) {
        return handlerMaps.get(cmdId);
    }

}
