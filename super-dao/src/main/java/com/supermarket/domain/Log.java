package com.supermarket.domain;

import com.supermarket.domain.base.SuperEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/30.
 */
@Table(name = "st_log")
public class Log extends SuperEntity {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "login_date")
    private Date loginDate;

    @Column(name = "logout_date")
    private Date logoutDate;

    @Column(name = "login_ip")
    private String ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
