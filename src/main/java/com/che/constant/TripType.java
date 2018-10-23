package com.che.constant;

public enum TripType {

    REGULAR_BUS(1, "班车"),
    FAST_CAR(2, "快车"),
    ;

    private Integer type;

    private String name;

    private TripType(Integer type, String name) {

        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getType() {
        return type;
    }
}
