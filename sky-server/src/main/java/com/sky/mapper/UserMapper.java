package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 查询满足条件的用户数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);

    @Select("select * from user where id = #{id}")
    User getById(Long userId);

}
