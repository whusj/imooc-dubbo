package com.imooc.controller;

import com.imooc.po.Orders;
import com.imooc.service.CulsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CulsterService culsterService;

    @RequestMapping("/say")
    public String sayHello(String name) {
        System.out.println("Dubbo consummer OrderController[name: "+name+"]");
        return culsterService.ordersSayHello(name);
    }

    @RequestMapping("/createOrder")
    public boolean createOrder(String itemId,int orderNum) {
        System.out.println("Dubbo consummer OrderController-createOrder()[itemId: "+itemId+",orderNum:"+orderNum+"]");
        return culsterService.createOrder(itemId,orderNum);
    }

    @RequestMapping("/getOrder")
    public Orders getOrder(String orderId) {
        System.out.println("Dubbo consummer OrderController-getOrder()[orderId: "+orderId+"]");
        return culsterService.getOrder(orderId);
    }
}
