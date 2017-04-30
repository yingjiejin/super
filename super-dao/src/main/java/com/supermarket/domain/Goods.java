package com.supermarket.domain;

import com.supermarket.domain.base.SuperEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/30.
 */
@Table(name = "st_goods")
public class Goods extends SuperEntity {

    @Id
    @Column(name = "goods_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "goods_name")
    private String name;

    @Column(name = "goods_company")
    private String company;

    @Column(name = "goods_type")
    private String type;

    @Column(name = "goods_cost")
    private double cost;

    @Column(name = "goods_price")
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
