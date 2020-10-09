package com.mars.api.exploration;

public enum CardinalPoints {
    N("N"),
    S("S"),
    W("W"),
    E("E");

    private String value;
    CardinalPoints(String value){
        this.value = value;
    }
}
