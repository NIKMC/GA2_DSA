package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 * Created by NIKMC on 25.11.16.
 */
public class MyRectangle extends MyShape {


    private Point leftTop;
    private int height;
    private int width;
    private Line leftVtx;
    private Line rightVtx;
    private Line bottomVtx;


    public MyRectangle(Point leftTop, int width, int height, BufferedImage image) {
        this.leftTop = leftTop;
        this.height = height;
        this.width = width;
        int pixelColor = new Color(33, 25, 255).getRGB();
        this.leftVtx = new Line(leftTop, new Point(leftTop.x, leftTop.y + height));//, image, pixelColor);
        this.bottomVtx = new Line(new Point(leftTop.x, leftTop.y + height), new Point(leftTop.x + width, leftTop.y + height));//, image, pixelColor);
        this.rightVtx = new Line(new Point(leftTop.x + width, leftTop.y + height), new Point(leftTop.x + width, leftTop.y));//, image, pixelColor);
        this.leftVtx.DrawLine(image,pixelColor);
        this.rightVtx.DrawLine(image,pixelColor);
        this.bottomVtx.DrawLine(image,pixelColor);
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
            if (rX < leftTop.getX()) lines.add(leftVtx);
            lines.add(bottomVtx);
        }
        else{
            lines.add(bottomVtx);
            if (rX > leftTop.getX() + width) lines.add(rightVtx);
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
