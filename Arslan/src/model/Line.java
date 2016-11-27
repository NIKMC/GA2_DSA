package model;

import functionality.Checker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by NIKMC on 25.11.16.
 */
public class Line {

    final int scale = 4;
    private Point start;
    private Point finish;


    public Line(Point start, Point finish){//, BufferedImage image, int pixelColor) {
        this.start = start;
        this.finish = finish;
        //DrawLine(image, pixelColor);
    }

    public void DrawLine(BufferedImage image, int pixelColor){
        //ImageIO.read(resultFile);
        if(start.x == finish.x){
            int yIter;
            for(yIter = start.y; yIter != finish.y; yIter += (finish.y - start.y)/Math.abs(finish.y - start.y))
                image.setRGB(start.x * scale, yIter * scale, pixelColor);
            image.setRGB(start.x * scale, yIter * scale, pixelColor);
        }
        else{
            double k = (double)(finish.y - start.y) / (finish.x - start.x);
            int yCrnt, xIter;
            for(xIter = start.x; xIter != finish.x; xIter += (finish.x - start.x)/Math.abs(finish.x - start.x)) {
                yCrnt = start.y + (int)((xIter - start.x) * k);
                image.setRGB(xIter * scale, yCrnt * scale, pixelColor);
            }
            yCrnt = start.y + (int)((xIter - start.x) * k);
            image.setRGB(xIter * scale, yCrnt * scale, pixelColor);
        }
        File resultFile = new File("result.png");
        try {
            ImageIO.write(image, "png", resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
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


    public boolean isIntersecting(Line that){
        int orientThisToStr = Checker.Signum(this.getOrientation(that.getStart()));
        int orientThisToFin = Checker.Signum(this.getOrientation(that.getFinish()));
        int orientThatToStr = Checker.Signum(that.getOrientation(this.getStart()));
        int orientThatToFin = Checker.Signum(that.getOrientation(this.getFinish()));

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

    public int getOrientation(Point pointUnderTest) {
        int y1 = this.start.y;
        int x1 = this.start.x;
        int y2 = this.finish.y;
        int x2 = this.finish.x;
        int y3 = pointUnderTest.y;
        int x3 = pointUnderTest.x;
        return (y2-y1)*(x3-x2)-(y3-y2)*(x2-x1);
    }
}
