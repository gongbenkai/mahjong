/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.room;

import com.benai.mahjong.card.BaseCard;
import com.benai.mahjong.card.ICard;
import com.benai.mahjong.config.area.AreaConfig;
import com.benai.mahjong.player.IPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Data;


/**
 *
 * @author gongbenkai
 */
@Data
public class Room implements IRoom {

    private final String uuid;
    private final String code;
    private final String areaCode; //区域代码 

    private List<ICard> cards; //所有剩余牌
    private List<IPlayer> plays; //所有剩余牌
    
    private IPlayer tokenPlayer; //目前拥有令牌玩家
    
    
    private AreaConfig areaConfig;

    public Room(String code, String areaCode) {
        this.uuid = UUID.randomUUID().toString();
        this.code = code;
        this.areaCode = areaCode;
        
    }
    
    @Override
    public void putCardsToRoom(List<BaseCard> orgCards) {
        cards = (List)(((ArrayList)orgCards).clone());
    }

    public boolean hasCards() {
        return !(cards == null || cards.isEmpty());
    }

    public ICard getOneHeadCard() {
        if (!this.hasCards()) {
            return null;
        }

        // 不采用一开始就把牌洗乱，每次顺序拿防止被破能够知道后面的牌是什么（效率或者复盘有问题没有）
        synchronized (cards) {
            return cards.remove(ThreadLocalRandom.current().nextInt(cards.size()));
        }

    }
    
    public ICard getOneTailCard() {
        if (!this.hasCards()) {
            return null;
        }

        // 不采用一开始就把牌洗乱，每次顺序拿防止被破能够知道后面的牌是什么（效率或者复盘有问题没有）
        synchronized (cards) {
            return cards.remove(ThreadLocalRandom.current().nextInt(cards.size()));
        }

    }

}
