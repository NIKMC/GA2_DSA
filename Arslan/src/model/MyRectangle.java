package model;

import java.awt.*;

/**
 * Created by NIKMC on 25.11.16.
 */
public class MyRectangle extends Shape{

    private Point leftTop;
    private int height;
    private int width;
    private Line leftVtx;
    private Line rightVtx;
    private Line bottomVtx;

    @Override
    public Point getCoord() {
        return leftTop;
    }

    @Override
    public boolean checkIntersection(Line fire) {
        return false;
    }


    public MyRectangle(Point leftTop, int width, int height) {
        this.leftTop = leftTop;
        this.height = height;
        this.width = width;
        this.leftVtx = new Line(leftTop, new Point(leftTop.x, leftTop.y + height));
        this.bottomVtx = new Line(new Point(leftTop.x, leftTop.y + height), new Point(leftTop.x + width, leftTop.y + height));
        this.rightVtx = new Line(new Point(leftTop.x + width, leftTop.y + height), new Point(leftTop.x + width, leftTop.y));
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
