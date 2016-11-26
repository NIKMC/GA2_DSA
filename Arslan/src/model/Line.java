package model;

import functionality.Checker;

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

    public boolean isIntersecting(Line that){
        int orientThisToStr = Checker.Signum(getOrientation(this, that.getStart());
        int orientThisToFin = Checker.Signum(getOrientation(this, that.getFinish());
        int orientThatToStr = Checker.Signum(getOrientation(that, this.getStart());
        int orientThatToFin = Checker.Signum(getOrientation(that, this.getFinish());

        //if collinear
        if(orientThisToStr == 0 && orientThisToFin == 0){
            if(((isXBetweenXProjection(that.getStart().x)) || (isXBetweenXProjection(that.getFinish().x))) &&
                    ((isYBetweenYProjection(that.getStart().y)) || (isYBetweenYProjection(that.getFinish().y)))){
                return true;
            }
            else
                return false;
        }
        // general case
        else {
            if ((orientThatToFin != orientThatToStr) && (orientThisToFin != orientThisToStr))
                return true;
            else
                return false;
        }



//        if(Checker.Signum(getOrientation(this, that.getFinish())) != ))
//            if (ge)
        return false;
    }

    boolean isXBetweenXProjection(int xCoord){
        if(this.start.x == this.finish.x){
            if(this.start.x == xCoord)
                return true;
            else
                return false;
        }
        else {
            if (Checker.Signum(this.start.x - xCoord) != Checker.Signum(this.finish.x - xCoord))
                return true;
            else
                return false;
        }
    }

    boolean isYBetweenYProjection(int yCoord){
        if(this.start.y == this.finish.y){
            if(this.start.y == yCoord)
                return true;
            else
                return false;
        }
        else {
            if (Checker.Signum(this.start.y - yCoord) != Checker.Signum(this.finish.y - yCoord))
                return true;
            else
                return false;
        }
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
