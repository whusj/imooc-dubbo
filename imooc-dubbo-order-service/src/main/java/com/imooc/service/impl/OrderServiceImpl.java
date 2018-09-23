package com.imooc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.imooc.service.OrderService;
import com.imooc.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.imooc.po.Orders;
import java.util.UUID;

@Service(interfaceClass = OrderService.class) //dubbo的service，注入接口
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public String ordersSayHello(String name) {
        System.out.println("Dubbo provider OrderService[name: "+name+"]");
        return "OrderService hello " + name ;
    }

    /**
     * @Description: 根据订单id查询订单
     */
    public Orders getOrder(String orderId){
        return ordersMapper.selectByPrimaryKey(orderId);
    }

    /**
     * @Description: 下订单
     */
    public boolean createOrder(String itemId,int orderNum){
        // 创建订单
        String oid = UUID.randomUUID().toString().replaceAll("-", "");
        Orders o = new Orders();
        o.setId(oid);
        o.setItemId(itemId);
        o.setOrderNum(orderNum);
        ordersMapper.insert(o);
        System.out.println("订单创建成功");
        return true;
    }
}
