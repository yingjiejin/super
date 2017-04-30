package com.supermarket.domain;

import com.supermarket.domain.base.SuperEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/30.
 */
@Table(name = "st_market")
public class Market extends SuperEntity {

    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "goods_id")
    private String goodsId;

    @Column(name = "sales_quantity")
    private int quantity;

    @Column(name = "amount_receivable")
    private double receivable;

    @Column(name = "discount_rate")
    private double rate;

    @Column(name = "amount_paidvar")
    private double paidvar;

    @Column(name = "sale_date")
    private Date sale_date;

    @Column(name = "operator_id")
    private int operatorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getReceivable() {
        return receivable;
    }

    public void setReceivable(double receivable) {
        this.receivable = receivable;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPaidvar() {
        return paidvar;
    }

    public void setPaidvar(double paidvar) {
        this.paidvar = paidvar;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getGoodsId() {

        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
