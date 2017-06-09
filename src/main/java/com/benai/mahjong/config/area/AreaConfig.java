/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.config.area;

import lombok.Data;

/**
 *
 * @author gongbenkai
 */
@Data
public class AreaConfig {
    
    private String areaCode;       //区域代码
    private Integer initCardsCode; //牌代码
    private String initHanlder; //发牌hander名称
    
}
