/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.executor;

/**
 *
 * @author gongbenkai
 */
public interface IExecutor <R, P> {
    
    R excutor(P p);
}
