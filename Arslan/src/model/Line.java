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
}
