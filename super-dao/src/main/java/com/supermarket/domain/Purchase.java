package com.supermarket.domain;

import com.supermarket.domain.base.SuperEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/30.
 */
@Table(name = "st_purchase")
public class Purchase extends SuperEntity {

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "goods_id")
    private String goodsId;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "purchase_quantity")
    private int quantity;

    @Column(name = "payment_amount")
    private double amount;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "operator_id")
    private int operatorId;

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

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }
}
