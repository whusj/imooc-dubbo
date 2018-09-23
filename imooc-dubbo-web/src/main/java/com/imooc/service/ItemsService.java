package com.imooc.service;

import com.imooc.po.Items;

public interface ItemsService {

    /**
     * @Description: 测试接口
     */
    public String itemsSayHello(String name);

    /**
     * @Description: 查询商品信息
     */
    public Items getItem(String itemId);

    /**
     * @Description: 查询商品库存
     */
    public int getItemCounts(String itemId);

    /**
     * @Description: 购买商品成功后减少库存
     */
    public boolean displayReduceCounts(String itemId, int buyCounts);

}
