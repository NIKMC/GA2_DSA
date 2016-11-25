package model;

import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Created by NIKMC on 25.11.16.
 */
public class Line {
    private Point start;
    private Point finish;


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

    public Double getAngle(){      // from 0 to 180 degrees
        Double a = finish.getX() - start.getX();
        Double b = - finish.getY() + start.getY();
        Double piAngle = Math.atan(a/b);
        Double angle = piAngle/(2*Math.PI) * 360;
        System.out.println(angle);
        return angle;
    }

    public boolean isInAttackArea( RocketLauncherUltimateNitroTurboBoostSuperSpace3000 r){
        return r.getAttackAngle() >= this.getAngle() && this.getAngle() >= -r.getAttackAngle();
    }

    public static void main(String[] args) {
        Line l = new Line(new Point(10,10), new Point(9,9));
        l.getAngle();
    }
}
