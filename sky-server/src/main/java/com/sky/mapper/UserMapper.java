package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 查询满足条件的用户数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);

}
