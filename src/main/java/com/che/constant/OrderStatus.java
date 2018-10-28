package com.che.constant;

public enum OrderStatus {

    UN_PAY(1, "待支付"),
    PAYED(2, "已支付"),
    SUCCESS(3, "交易成功"),
    CANCEL(4, "取消"),
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
