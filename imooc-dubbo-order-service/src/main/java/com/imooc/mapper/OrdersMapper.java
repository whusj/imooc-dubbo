package com.imooc.mapper;

import org.apache.ibatis.annotations.*;
import com.imooc.po.Orders;

/**
 * User映射类
 * Created by Administrator on 2017/11/24.
 */
@Mapper
public interface OrdersMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "itemId", column = "item_id")
    })


    @Insert("insert into orders (id, order_num, item_id) VALUES(#{id}, #{orderNum}, #{itemId})")
    int insert(Orders record);

    @Select("SELECT * FROM orders WHERE ID = #{orderId}")
    Orders selectByPrimaryKey(@Param("orderId") String orderId);

}
