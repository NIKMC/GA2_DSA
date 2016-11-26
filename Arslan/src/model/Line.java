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

    final int IMG_WIDTH = 600;
    private Point start;
    private Point finish;


    public Line(Point start, Point finish, String resultImgPath) {
        this.start = start;
        this.finish = finish;



        File resultFile = new File(resultImgPath);
        int imgWidth = IMG_WIDTH;
        int pixelColor = new Color(33, 25, 255).getRGB();
        try {
            BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_RGB);//ImageIO.read(resultFile);
                image.setRGB(150, 150, pixelColor);
            ImageIO.write(image, "png", resultFile);
        }
        catch (IOException e) {

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

    public static void main(String[] args) {
        Line l = new Line(new Point(10,10), new Point(9,9), "result.png");
        l.getAngle();
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
