package com.imooc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.imooc.service.ItemsService;

@Service(interfaceClass = ItemsService.class) //dubbo的service，注入接口
public class ItemsServiceImpl implements ItemsService{
    @Override
    public String sayHello(String name) {
        System.out.println("Dubbo provider ItemsService[name: "+name+"]");
        return "ItemsService hello " + name ;
    }
}
