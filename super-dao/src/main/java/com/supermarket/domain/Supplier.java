package com.supermarket.domain;

import com.supermarket.domain.base.SuperEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/30.
 */
@Table(name = "st_supplier")
public class Supplier extends SuperEntity {

    @Id
    @Column(name = "supplier_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "supplier_name")
    private String name;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "address")
    private String address;

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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
