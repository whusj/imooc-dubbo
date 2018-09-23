package com.imooc.po;

import java.io.Serializable;

public class Orders implements Serializable {
    private static final long serialVersionUID = -8247834542760425065L;

    private String id;

    private int orderNum;

    private String itemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }
}