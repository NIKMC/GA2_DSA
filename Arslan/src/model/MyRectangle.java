package model;

import java.awt.*;

/**
 * Created by NIKMC on 25.11.16.
 */
public class MyRectangle extends Shape{

    @Override
    public Point getCoord() {
        return leftTop;
    }

    @Override
    public boolean checkIntersection(Line fire) {
        return false;
    }

    private Point leftTop;
    private int height;
    private int width;

    public MyRectangle(Point leftTop, int width, int height) {
        this.leftTop = leftTop;
        this.height = height;
        this.width = width;
    }

    public Point getLeftTop() {
        return leftTop;
    }

    public void setLeftTop(Point leftTop) {
        this.leftTop = leftTop;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
