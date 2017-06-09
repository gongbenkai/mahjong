/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.handler.init;

import com.benai.mahjong.cache.CacheInterface;
import com.benai.mahjong.card.BaseCard;
import com.benai.mahjong.player.IPlayer;
import com.benai.mahjong.room.IRoom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gongbenkai
 */
@Component("initHandler")
public class InitHandler implements IInitHandler{
    
    @Autowired
    CacheInterface<Integer, List<BaseCard>> initCardsCache;
    
    public boolean doHandler(IRoom room, IPlayer player) {
        // 初始化房间的可用牌
        room.putCardsToRoom(initCardsCache.getKey(room.getAreaConfig().getInitCardsCode()));

        // 标准13张牌
        for(int i = 0; i < 13; i++) {
            //每人发一张牌
            room.getPlays().stream().forEach((p) -> {
                p.addCard(room.getOneHeadCard());
            });
        }
                
        return true;
        
    }
}
