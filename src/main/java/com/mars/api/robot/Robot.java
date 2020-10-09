package com.mars.api.robot;

public class Robot {
    private Integer x;
    private Integer y;
    private String cardinalPoint;

    public Robot(Integer x, Integer y, String cardinalPoint){
        this.x = x;
        this.y = y;
        this.cardinalPoint = cardinalPoint;
    }

    public Robot(){
        this(0,0,"N");
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getCardinalPoint() {
        return cardinalPoint;
    }

    public void setCardinalPoint(String cardinalPoint) {
        this.cardinalPoint = cardinalPoint;
    }
}
