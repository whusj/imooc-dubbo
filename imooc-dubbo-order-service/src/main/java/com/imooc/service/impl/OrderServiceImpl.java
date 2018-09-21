package com.imooc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.imooc.service.OrderService;

@Service(interfaceClass = OrderService.class) //dubbo的service，注入接口
public class OrderServiceImpl implements OrderService {
    @Override
    public String sayHello(String name) {
        System.out.println("Dubbo provider OrderService[name: "+name+"]");
        return "OrderService hello " + name ;
    }
}
