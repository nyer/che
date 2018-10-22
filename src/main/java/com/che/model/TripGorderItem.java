package com.che.model;

public class TripGorderItem {
    private Long gorderItemId;

    private Long gorderId;

    private Long orderId;

    private Long createTime;

    private Long updateTime;

    public Long getGorderItemId() {
        return gorderItemId;
    }

    public void setGorderItemId(Long gorderItemId) {
        this.gorderItemId = gorderItemId;
    }

    public Long getGorderId() {
        return gorderId;
    }

    public void setGorderId(Long gorderId) {
        this.gorderId = gorderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
}