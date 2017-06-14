/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author gongbenkai
 */
public class RandomUtil {
    
    public static String random6D() {
        return String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
    }
    
}
