package com.che.model;

import java.util.List;

public class TripGorder {
    private Long gorderId;

    private Long gorderUserId;

    private Long gorderTime;

    private Long createTime;

    private Long updateTime;

    private List<TripOrder> orders;

    public Long getGorderId() {
        return gorderId;
    }

    public void setGorderId(Long gorderId) {
        this.gorderId = gorderId;
    }

    public Long getGorderUserId() {
        return gorderUserId;
    }

    public void setGorderUserId(Long gorderUserId) {
        this.gorderUserId = gorderUserId;
    }

    public Long getGorderTime() {
        return gorderTime;
    }

    public void setGorderTime(Long gorderTime) {
        this.gorderTime = gorderTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public List<TripOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<TripOrder> orders) {
        this.orders = orders;
    }
}