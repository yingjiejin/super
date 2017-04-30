package com.supermarket.domain.base;

import com.google.gson.Gson;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/30.
 */
public class SuperEntity extends BaseEntity {

    @Transient
    private transient Gson gson = new Gson();

    public <T extends SuperEntity> T exchange(Class<T> clazz) {
        return gson.fromJson(gson.toJson(this), clazz);
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @Column(name = "del_flag")
    private Boolean deleteFlag;

    @Column(name = "ins_process_id")
    private String insertProcessId;

    @Column(name = "ins_dt")
    private Date insertTime;

    @Column(name = "upd_process_id")
    private String updateProcessId;

    @Column(name = "upd_dt")
    private Date updateTime;

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getInsertProcessId() {
        return insertProcessId;
    }

    public void setInsertProcessId(String insertProcessId) {
        this.insertProcessId = insertProcessId;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateProcessId() {
        return updateProcessId;
    }

    public void setUpdateProcessId(String updateProcessId) {
        this.updateProcessId = updateProcessId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
