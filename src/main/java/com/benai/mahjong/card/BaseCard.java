/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.card;

import lombok.Data;

/**
 *
 * @author gongbenkai
 */
@Data
public class BaseCard implements ICard, Comparable<BaseCard>{
    
    private int type; // 1- 5,对应同万条风花
    private int seq; // 序列 1～N

    @Override
    public int compareTo(BaseCard o) {
        if (this.type > o.getType()) {
            return 1;
        } else if (this.type < o.getType()) {
            return -1;
        }
        if (this.seq > o.getSeq()) {
            return 1;
        } else if (this.seq < o.getSeq()) {
            return -1;
        } else {
            return 0;
        }
    }
}
