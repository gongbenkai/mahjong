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
import java.util.List;

/**
 *
 * @author gongbenkai
 */
public interface IRoom {
    
    // 取得区域配置i性能系
    AreaConfig getAreaConfig();
    
    // 初始化房间牌
    void putCardsToRoom(List<BaseCard> orgCards);
    
    // 取得所有玩家
    List<IPlayer> getPlays();
    
    // 从头部取得一张牌
    ICard getOneHeadCard();
    
    // 从尾部取得一张牌
    ICard getOneTailCard();
}
