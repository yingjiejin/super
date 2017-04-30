package com.supermarket.domain;

import com.supermarket.domain.base.SuperEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/30.
 */
@Table(name = "st_stock")
public class Stock extends SuperEntity {

    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "goods_id")
    private String goodsId;

    @Column(name = "inventory_quantity")
    private int inventory_quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getInventory_quantity() {
        return inventory_quantity;
    }

    public void setInventory_quantity(int inventory_quantity) {
        this.inventory_quantity = inventory_quantity;
    }
}
