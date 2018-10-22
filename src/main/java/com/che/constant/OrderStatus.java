package com.che.constant;

public enum OrderStatus {

    WAITING_CAR(1, "待上车"),
    CAR_ARRIVED(2, "车到达"),
    IN_CAR(3, "已上车"),
    STATION_REACHED(4, "到达站点"),
    PAYED(5, "已支付"),
    CANCEL(6, "取消"),
    FAILED(7, "失败"),
    ;
    private int status;
    private String desc;

    private OrderStatus(int status, String desc) {
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
