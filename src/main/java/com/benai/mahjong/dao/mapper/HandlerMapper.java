/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author gongbenkai
 */
public interface HandlerMapper {

    @Select("select hanlder from init_handler where areaCode = #{areaCode}")
    String getInitHandler(@Param("areaCode") Integer areaCode);
    
}
