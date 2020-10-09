package com.mars.api.robot;

public enum Commands {
    R("R"),
    L("L"),
    M("M");

    private String value;
    Commands (String value){
        this.value = value;
    }
}
