/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.player;

import com.benai.mahjong.card.ICard;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author gongbenkai
 */
@Data
public class Player implements IPlayer {
    
    private final List<ICard> cards = new ArrayList<>();

    @Override
    public void addCard(ICard card) {
        cards.add(card);
    }

    @Override
    public void clearCards() {
        if (!cards.isEmpty()) {
            cards.clear();
        }
    }
}
