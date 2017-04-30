package com.supermarket.domain;

import com.supermarket.domain.base.SuperEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/30.
 */
@Table(name = "st_goods_type")
public class GoodsType extends SuperEntity {

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_name")
    private String name;

    @Column(name = "type_explain")
    private String explain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
