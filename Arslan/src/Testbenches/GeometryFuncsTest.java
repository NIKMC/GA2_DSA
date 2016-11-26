package Testbenches;

import model.Line;

import java.awt.*;

/**
 * Created by Carioca on 25/11/2016.
 */
public class GeometryFuncsTest {
    public static void main(String []args){
        Line newLine = new Line(new Point(1,5), new Point(3,5));
        Line interLine = new Line(new Point(2,4), new Point(2,6));
        int isInters = newLine.getOrientation(interLine.getFinish());
        System.out.println(isInters);
    }
}
