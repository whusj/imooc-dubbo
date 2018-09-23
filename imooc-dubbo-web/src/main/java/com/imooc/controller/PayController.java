package com.imooc.controller;

import com.imooc.common.utils.IMoocJSONResult;
import com.imooc.curator.utils.ZKCurator;
import com.imooc.po.Items;
import com.imooc.po.Orders;
import com.imooc.service.CulsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private CulsterService culsterService;
    @Autowired
    private ZKCurator zkCurator;

    @RequestMapping("/item/say")
    public String itemsSayHello(String name) {
        System.out.println("Dubbo consummer ItemController[name: "+name+"]");
        return culsterService.itemsSayHello(name);
    }

    @RequestMapping("/item/getItem")
    public Items getItem(String itemId) {
        System.out.println("Dubbo consummer ItemController-getItem()[itemId: "+itemId+"]");
        return culsterService.getItem(itemId);
    }


    @RequestMapping("/item/getItemCounts")
    public int getItemCounts(String itemId) {
        System.out.println("Dubbo consummer ItemController-getItem()[itemId: "+itemId+"]");
        return culsterService.getItemCounts(itemId);
    }

    @RequestMapping("/order/say")
    public String ordersSayHello(String name) {
        System.out.println("Dubbo consummer OrderController[name: "+name+"]");
        return culsterService.ordersSayHello(name);
    }

    @RequestMapping("/order/createOrder")
    public boolean createOrder(String itemId,int orderNum) {
        System.out.println("Dubbo consummer OrderController-createOrder()[itemId: "+itemId+",orderNum:"+orderNum+"]");
        return culsterService.createOrder(itemId,orderNum);
    }

    @RequestMapping("/order/getOrder")
    public Orders getOrder(String orderId) {
        System.out.println("Dubbo consummer OrderController-getOrder()[orderId: "+orderId+"]");
        return culsterService.getOrder(orderId);
    }

    @RequestMapping("/buy")
    public IMoocJSONResult buy(String itemId,int count) {
        boolean result = culsterService.displayBuy(itemId,count);
        return IMoocJSONResult.ok(result ? "订单创建成功..." : "订单创建失败...");
    }

    /**
     * @Description: 模拟集群下的数据不一致
     */
    @RequestMapping("/buy2")
    public IMoocJSONResult buy2(String itemId,int count) {
        boolean result = culsterService.displayBuy(itemId,count);
        return IMoocJSONResult.ok(result ? "订单创建成功..." : "订单创建失败...");
    }

    /**
     * @Description: 判断zk是否连接
     */
    @RequestMapping("/isZKAlive")
    @ResponseBody
    public IMoocJSONResult isZKAlive() {
        boolean isAlive = zkCurator.isZKAlive();
        String result = isAlive ? "连接" : "断开";
        return IMoocJSONResult.ok(result);
    }
}
