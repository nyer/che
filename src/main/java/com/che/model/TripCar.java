package com.che.model;

public class TripCar {
    private Long id;

    private Long tripId;

    private Integer spareSeatCount;

    private Integer carSource;

    private String carLicense;

    private String phone;

    private Long createTime;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Integer getSpareSeatCount() {
        return spareSeatCount;
    }

    public void setSpareSeatCount(Integer spareSeatCount) {
        this.spareSeatCount = spareSeatCount;
    }

    public Integer getCarSource() {
        return carSource;
    }

    public void setCarSource(Integer carSource) {
        this.carSource = carSource;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense == null ? null : carLicense.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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