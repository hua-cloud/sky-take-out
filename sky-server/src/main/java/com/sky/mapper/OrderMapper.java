package com.sky.mapper;

import com.sky.dto.GoodsSalesDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    /**
     * 更新订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 根据支付状态和下单时间查询订单
     * @param status
     * @param orderTime
     * @return
     */
    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrderTimeLT(Integer status, LocalDateTime orderTime);

    /**
     * 查询特定日期的营业总金额
     * @param map
     * @return
     */
    Double sumByMap(Map map);

    /**
     * 统计订单数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);

    /**
     * 获取销量前十的商品名称与对应销量
     * @param begin
     * @param end
     * @return
     */
    List<GoodsSalesDTO> getSalesTop10(LocalDateTime begin, LocalDateTime end);

}
