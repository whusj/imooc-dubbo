package com.imooc.controller;

import com.imooc.po.Items;
import com.imooc.service.CulsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private CulsterService culsterService;

    @RequestMapping("/say")
    public String sayHello(String name) {
        System.out.println("Dubbo consummer ItemController[name: "+name+"]");
        return culsterService.itemsSayHello(name);
    }

    @RequestMapping("/getItem")
    public Items getItem(String itemId) {
        System.out.println("Dubbo consummer ItemController-getItem()[itemId: "+itemId+"]");
        return culsterService.getItem(itemId);
    }


    @RequestMapping("/getItemCounts")
    public int getItemCounts(String itemId) {
        System.out.println("Dubbo consummer ItemController-getItem()[itemId: "+itemId+"]");
        return culsterService.getItemCounts(itemId);
    }
}
