/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benai.mahjong.dao.mapper;

import com.benai.mahjong.card.BaseCard;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author gongbenkai
 */
public interface CardMapper {

    @Select("SELECT type, seq from card where code = #{code} order by orderVal")
    List<BaseCard> getInitCardsByCode(@Param("code") int code);
    
}
