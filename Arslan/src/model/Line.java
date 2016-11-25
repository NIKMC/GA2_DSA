package model;

import java.awt.*;

/**
 * Created by NIKMC on 25.11.16.
 */
public class Line {
    Point start;
    Point finish;


    public Line(Point start, Point finish) {
        this.start = start;
        this.finish = finish;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getFinish() {
        return finish;
    }

    public void setFinish(Point finish) {
        this.finish = finish;
    }

    public boolean isIntersecting(Line that){
        return false;
    }

    public static int getOrientation(Line segment, Point pointUnderTest) {
        int y1 = segment.getStart().y;
        int x1 = segment.getStart().x;
        int y2 = segment.getFinish().y;
        int x2 = segment.getFinish().x;
        int y3 = pointUnderTest.y;
        int x3 = pointUnderTest.x;
        return (y2-y1)*(x3-x2)-(y3-y2)*(x2-x1);
    }
}
