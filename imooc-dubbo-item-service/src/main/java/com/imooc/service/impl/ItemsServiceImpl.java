package com.imooc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.imooc.service.ItemsService;
import com.imooc.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.imooc.po.Items;

@Service(interfaceClass = ItemsService.class) //dubbo的service，注入接口
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsMapper itemsMapper;

    public String itemsSayHello(String name){
        System.out.println("Dubbo provider ItemsService[name: "+name+"]");
        return "OrderService hello " + name ;
    }

    @Override
    public Items getItem(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public int getItemCounts(String itemId) {
        Items item = itemsMapper.selectByPrimaryKey(itemId);
        return item.getCounts();
    }

    @Override
    public boolean displayReduceCounts(String itemId, int buyCounts) {
        Items reduceItem = new Items();
        reduceItem.setId(itemId);
        reduceItem.setBuyCounts(buyCounts);
        itemsMapper.reduceCounts(reduceItem);
        return true;
    }
}
