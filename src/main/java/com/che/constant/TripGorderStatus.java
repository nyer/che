package com.che.constant;

public enum TripGorderStatus {

    NOT_START(1, "未开始"),
    SERVING(2, "进行中"),
    FINISHED(3, "完成"),
    ;
    private int status;
    private String desc;

    TripGorderStatus(int status, String desc) {
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
