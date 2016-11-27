package functionality;

import model.Line;
import model.MyCircle;
import model.MyRectangle;
import model.RocketLauncherUltimateNitroTurboBoostSuperSpace3000;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Stanislav on 26.11.2016.
 */
public class BattleField {
    final int IMG_WIDTH = 600;
    final static String resultPNGpath = "result.png";


    public void fight(){
        Reader fileReader = new Reader();
        File resultFile = new File(resultPNGpath);
        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_RGB);
        /*for(MyCircle circle : fileReader.readerObstaclesCircle()){
            System.out.println(circle.getCenter().x + " | " + circle.getCenter().y + " | " + circle.getRadius());
            System.out.println(circle.checkIntersection(new Line(new Point(30,90),new Point(110,4))));
        }

        for(MyRectangle rectangle : fileReader.readerObstaclesRectangle())
            System.out.println(rectangle.getLeftTop().x + " | " + rectangle.getLeftTop().y + " | " +
                    rectangle.getWidth() + " | " + rectangle.getHeight());

        for (RocketLauncherUltimateNitroTurboBoostSuperSpace3000 rocket : fileReader.readerRocketLauncher())
            System.out.println(rocket.getLocation().x + " | " + rocket.getLocation().y );

        for(MyRectangle rectangle : fileReader.readerTargets())
            System.out.println(rectangle.getLeftTop().x + " | " + rectangle.getLeftTop().y + " | " +
                    rectangle.getWidth() + " | " + rectangle.getHeight());
        */

        ArrayList<Shape> obstacles = (ArrayList<Shape>) fileReader.readerObstaclesCircle(image);
        obstacles.addAll( (ArrayList<Shape>) fileReader.readerObstaclesRectangle(image) );
        ArrayList<RocketLauncherUltimateNitroTurboBoostSuperSpace3000> launchers = (ArrayList<RocketLauncherUltimateNitroTurboBoostSuperSpace3000>) fileReader.readerRocketLauncher(image);
        ArrayList<MyRectangle> targets = (ArrayList<MyRectangle>) fileReader.readerTargets(image);

        for(RocketLauncherUltimateNitroTurboBoostSuperSpace3000 launcher : launchers){
            for(MyRectangle target : targets){
                boolean underAttack = false;
                LinkedList<Line> targetSides = target.getObservableSides(launcher);
                for (int i = 0; i < targetSides.size() && !underAttack; i++) {
                    
                    //Line shootLien = new Line(launcher.getLocation(), targetPoint);
                } // for sides
            } // for target
        } // for launcher
        try {
            ImageIO.write(image, "png", resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}