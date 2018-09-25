package com.imooc.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.imooc.curator.utils.DistributedLock;
import com.imooc.po.Items;
import com.imooc.po.Orders;
import com.imooc.service.CulsterService;
import com.imooc.service.ItemsService;
import com.imooc.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CulsterServiceImpl implements CulsterService {


    final static Logger log = LoggerFactory.getLogger(CulsterServiceImpl.class);

    @Reference
    private ItemsService itemsService;

    @Reference
    private OrderService orderService;

    @Autowired
    private DistributedLock distributedLock;

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
        boolean ret = itemsService.displayReduceCounts(itemId,orderNum);
        if (ret){
            ret = orderService.createOrder(itemId,orderNum);
        }
        return ret;
    }

    @Transactional
    public boolean displayBuy(String itemId,int orderNum){

//		System.out.println("linux-pc...");
        System.out.println("windows-pc...");

        // 执行订单流程之前使得当前业务获得分布式锁
        distributedLock.getLock();

        int buyCounts = orderNum;

        // 1. 判断库存
        int stockCounts = itemsService.getItemCounts(itemId);
        if (stockCounts < buyCounts) {
            log.info("库存剩余{}件，用户需求量{}件，库存不足，订单创建失败...",
                    stockCounts, buyCounts);
            // 释放锁，让下一个请求获得锁
            distributedLock.releaseLock();
            return false;
        }

        // 2. 创建订单
        boolean isOrderCreated = orderService.createOrder(itemId,buyCounts);

        // 模拟处理业务需要3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            distributedLock.releaseLock();
        }

        // 3. 创建订单成功后，扣除库存
        if (isOrderCreated) {
            log.info("订单创建成功...");
            itemsService.displayReduceCounts(itemId, buyCounts);
        } else {
            log.info("订单创建失败...");
            // 释放锁，让下一个请求获得锁
            distributedLock.releaseLock();
            return false;
        }

        // 释放锁，让下一个请求获得锁
        distributedLock.releaseLock();
        return true;
    }
}
