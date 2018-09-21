package com.imooc.controller;

import com.imooc.service.impl.RefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private RefService refService;

    @RequestMapping("/say")
    public String sayHello(String name) {
        System.out.println("Dubbo consummer ItemController[name: "+name+"]");
        return refService.sayHello(name);
    }
}
