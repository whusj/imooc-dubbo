package com.imooc.controller;

import com.imooc.service.OrderService;
import com.imooc.service.impl.RefService;
import com.imooc.service.impl.RefService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RefService2 orderService;

    @RequestMapping("/say")
    public String sayHello(String name) {
        System.out.println("Dubbo consummer OrderController[name: "+name+"]");
        return orderService.sayHello(name);
    }
}
