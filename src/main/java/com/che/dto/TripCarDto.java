package com.che.dto;

public class TripCarDto {

    private Long tripId;

    private Integer spareSeatCount;

    private Integer carSource;

    private String carLicense;

    private String phone;

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
        this.carLicense = carLicense;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
