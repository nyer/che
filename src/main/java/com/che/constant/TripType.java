package com.che.constant;

public enum TripType {

    DRIVER(1, "车主"),
    PASSENGER(2, "乘客"),
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
