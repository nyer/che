package com.che.constant;

public enum DriverOrderStatus {

    UN_ARRIVE(1, "待到达乘客接送点"),
    ARRIVED(2, "到达乘客接送点"),
    PASSENGER_ABOARD(3, "乘客已上车"),
    DEST_ARRIVED(4, "到达乘客终点"),
    CANCEL(5, "取消"),
    ;
    private int status;
    private String desc;

    DriverOrderStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }
    
    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
