package com.imooc.service.impl;

import com.imooc.service.ItemsService;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Reference;

@Service("refService")
public class RefService {

    @Reference
    private ItemsService itemsService;

    public String sayHello(String name){
        return itemsService.sayHello(name);
    }
}
