package com.imooc.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.imooc.po.Items;
import com.imooc.po.Orders;
import com.imooc.service.CulsterService;
import com.imooc.service.ItemsService;
import com.imooc.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class CulsterServiceImpl implements CulsterService {

    @Reference
    private ItemsService itemsService;

    @Reference
    private OrderService orderService;

    /**
     * @Description: 测试接口
     */
    public String itemsSayHello(String name){
        return itemsService.itemsSayHello(name);
    }

    /**
     * @Description: 查询商品信息
     */
    public Items getItem(String itemId){
        return itemsService.getItem(itemId);
    }

    /**
     * @Description: 查询商品库存
     */
    public int getItemCounts(String itemId){
        return itemsService.getItemCounts(itemId);
    }

    /**
     * @Description: 购买商品成功后减少库存
     */
    public boolean displayReduceCounts(String itemId, int buyCounts){
        return itemsService.displayReduceCounts(itemId,buyCounts);
    }


    public String ordersSayHello(String name){
        return orderService.ordersSayHello(name);
    }

    /**
     * @Description: 根据订单id查询订单
     */
    public Orders getOrder(String orderId){
        return orderService.getOrder(orderId);
    }

    /**
     * @Description: 下订单
     */
    public boolean createOrder(String itemId,int orderNum){
        boolean ret = orderService.createOrder(itemId,orderNum);
        if (ret){
            ret = itemsService.displayReduceCounts(itemId,orderNum);
        }
        return ret;
    }
}
