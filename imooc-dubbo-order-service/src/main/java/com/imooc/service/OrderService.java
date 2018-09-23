package com.imooc.service;

import com.imooc.po.Orders;

public interface OrderService {

    /**
     * @Description: 接口测试
     */
    public String ordersSayHello(String name);

    /**
     * @Description: 根据订单id查询订单
     */
    public Orders getOrder(String orderId);

    /**
     * @Description: 下订单
     */
    public boolean createOrder(String itemId,int orderNum);
}
