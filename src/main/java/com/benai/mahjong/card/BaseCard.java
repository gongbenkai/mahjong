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
public class BaseCard {
    
    private int type; // 1- 5,对应同万条风花
    private int seq; // 序列 1～N
}
