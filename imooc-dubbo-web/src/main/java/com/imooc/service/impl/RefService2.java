package com.imooc.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.imooc.service.ItemsService;
import com.imooc.service.OrderService;
import org.springframework.stereotype.Service;

@Service("refService2")
public class RefService2 {
    @Reference
    private OrderService orderService;

    public String sayHello(String name){
        return orderService.sayHello(name);
    }
}
