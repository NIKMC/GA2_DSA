package model;


import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by NIKMC on 25.11.16.
 */
public class MyCircle extends MyShape {
    final int scale = 4;

    @Override
    public Point getCoord() {
        return center;
    }

    @Override
    public boolean checkIntersection(Line fire) {
        /*int x1 = fire.getStart().x;
        int y1 = fire.getStart().y;
        int x2 = fire.getFinish().x;
        int y2 = fire.getFinish().y;
        x1 -= getCenter().x;
        y1 -= getCenter().y;
        x2 -= getCenter().x;
        y2 -= getCenter().y;

        double dx = x2 - x1;
        double dy = y2 - y1;

        double a = dx*dx + dy*dy;
        double b = 2.*(x1*dx + y1*dy);
        double c = x1*x1 + y1*y1 - getRadius()*getRadius();

        if (-b < 0)
            return (c < 0);
        if (-b < (2.*a))
            return ((4.*a*c - b*b) < 0);
        return (a+b+c < 0);*/



        double a = (fire.getFinish().x - fire.getStart().x) * (fire.getFinish().x - fire.getStart().x)
                + (fire.getFinish().y - fire.getStart().y) * (fire.getFinish().y - fire.getStart().y);
        double b  = 2 * ((fire.getFinish().x - fire.getStart().x) * (fire.getStart().x - getCenter().x)
                + (fire.getFinish().y - fire.getStart().y) * (fire.getStart().y - getCenter().y));
        double c = getCenter().x * getCenter().x  + getCenter().y * getCenter().y
                + fire.getStart().x * fire.getStart().x + fire.getStart().y * fire.getStart().y
                - 2 * (getCenter().x * fire.getStart().x + getCenter().y * fire.getStart().y) - radius * radius;

        if ( - b < 0)
        {
            return (c < 0);
        }

        if ( - b < (2 * a))
        {
            return (4 * a * c - b * b < 0);
        }

        return (a + b + c < 0);

    }

    private Point center;
    private int radius;

    public MyCircle(Point center, int radius, BufferedImage image) {
        this.center = center;
        this.radius = radius;
        int pixelColor = new Color(33, 25, 255).getRGB();
        DrawCircle(image, pixelColor);
    }

    void DrawCircle(BufferedImage image, int pixelColor){
        int xIter, yIter, y1, y2;
        for(xIter = center.x - radius; xIter <= center.x + radius; xIter++){
            y1 = (int) (center.y + Math.sqrt(radius * radius - (xIter - center.x)*(xIter - center.x)));
            image.setRGB(xIter * scale, y1 * scale, pixelColor);
            y1 = (int) (center.y - Math.sqrt(radius * radius - (xIter - center.x)*(xIter - center.x)));
            image.setRGB(xIter * scale, y1 * scale, pixelColor);
        }
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
