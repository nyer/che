package com.che.constant;

public enum OrderStatus {

    UNPAY(1, "待支付"),
    FINISH(2, "完成"),
    CANCEL(3, "取消"),
    ;
    private int status;
    private String desc;

    OrderStatus(int status, String desc) {
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
