package com.imooc.service;

import com.imooc.po.Items;
import com.imooc.po.Orders;

public interface CulsterService {


    /**
     * @Description: 测试接口
     */
    public String itemsSayHello(String name);

    /**
     * @Description: 查询商品信息
     */
    public Items getItem(String itemId);

    /**
     * @Description: 查询商品库存
     */
    public int getItemCounts(String itemId);

    /**
     * @Description: 购买商品成功后减少库存
     */
    public boolean displayReduceCounts(String itemId, int buyCounts);

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

    public boolean displayBuy(String itemId,int orderNum);
}
