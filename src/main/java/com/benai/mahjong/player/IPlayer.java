/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.player;

import com.benai.mahjong.card.ICard;

/**
 *
 * @author gongbenkai
 */
public interface IPlayer {
    
    void addCard(ICard card);
    void clearCards();
}
