package model;


import java.awt.*;

/**
 * Created by NIKMC on 25.11.16.
 */
public class MyCircle extends Shape{

    @Override
    public Point getCoord() {
        return center;
    }

    @Override
    public boolean checkIntersection(Line fire) {
        return false;
    }

    private Point center;
    private int radius;

    public MyCircle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


}
