package com.che.constant;

import com.google.common.collect.Maps;

import java.util.Map;

public enum TripOrderStatus {

    UN_ARRIVE(1, "待到达乘客接送点"),
    ARRIVED(2, "到达乘客接送点"),
    PASSENGER_ABOARD(3, "乘客已上车"),
    DEST_ARRIVED(4, "到达乘客终点"),
    CANCEL(5, "取消"),
    ;

    static Map<Integer, TripOrderStatus> map = Maps.newHashMap();
    static {

        for (TripOrderStatus tripOrderStatus : values()) {

            map.put(tripOrderStatus.getStatus(), tripOrderStatus);
        }
    }
    private int status;
    private String desc;

    TripOrderStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }
    
    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static TripOrderStatus getByStatus(Integer status) {

        return map.get(status);
    }
}
