package model;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by NIKMC on 25.11.16.
 */
public class MyRectangle extends Shape{
    static String resultPNGpath = "result.png";


    private Point leftTop;
    private int height;
    private int width;
    private Line leftVtx;
    private Line rightVtx;
    private Line bottomVtx;


    public MyRectangle(Point leftTop, int width, int height) {
        this.leftTop = leftTop;
        this.height = height;
        this.width = width;
        this.leftVtx = new Line(leftTop, new Point(leftTop.x, leftTop.y + height), resultPNGpath);
        this.bottomVtx = new Line(new Point(leftTop.x, leftTop.y + height), new Point(leftTop.x + width, leftTop.y + height), resultPNGpath);
        this.rightVtx = new Line(new Point(leftTop.x + width, leftTop.y + height), new Point(leftTop.x + width, leftTop.y), resultPNGpath);
    }

    @Override
    public Point getCoord() {
        return leftTop;
    }

    @Override
    public boolean checkIntersection(Line fire) {
        if(leftVtx.isIntersecting(fire))
            return true;
        if(bottomVtx.isIntersecting(fire))
            return true;
        if(rightVtx.isIntersecting(fire))
            return true;
        return false;
    }

    public LinkedList<Line> getObservableSides(RocketLauncherUltimateNitroTurboBoostSuperSpace3000 r){
        LinkedList<Line>  lines = new LinkedList<Line>();
        int rX = (int) r.getLocation().getX();
        int rY = (int) r.getLocation().getY();
        if(rX < leftTop.getX() + width/2){
            lines.add(bottomVtx);
            if (rX < leftTop.getX()) lines.add(leftVtx);
        }
        else{
            if (rX > leftTop.getX() + width) lines.add(rightVtx);
            lines.add(bottomVtx);
        }

        return lines;
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
