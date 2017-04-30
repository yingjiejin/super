package com.supermarket.domain;

import com.supermarket.domain.base.SuperEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/30.
 */
@Table(name = "st_employee")
public class Employee extends SuperEntity {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_password")
    private String password;

    @Column(name = "employee_type")
    private String type;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
