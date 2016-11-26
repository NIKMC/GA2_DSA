package functionality;

import model.Line;
import model.MyCircle;
import model.MyRectangle;
import model.RocketLauncherUltimateNitroTurboBoostSuperSpace3000;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Stanislav on 26.11.2016.
 */
public class BattleField {

    public void fight(){
        Reader fileReader = new Reader();
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

        ArrayList<Shape> obstacles = (ArrayList<Shape>) fileReader.readerObstaclesCircle();
        obstacles.addAll( (ArrayList<Shape>) fileReader.readerObstaclesRectangle() );
        ArrayList<RocketLauncherUltimateNitroTurboBoostSuperSpace3000> launchers = (ArrayList<RocketLauncherUltimateNitroTurboBoostSuperSpace3000>) fileReader.readerRocketLauncher();
        ArrayList<MyRectangle> targets = (ArrayList<MyRectangle>) fileReader.readerTargets();

        for(RocketLauncherUltimateNitroTurboBoostSuperSpace3000 launcher : launchers){
            for(MyRectangle target : targets){
                boolean underAttack = false;
                LinkedList<Line> targetSides = target.getObservableSides(launcher);
                for (int i = 0; i < targetSides.size() && !underAttack; i++) {
                    
                    //Line shootLien = new Line(launcher.getLocation(), targetPoint);
                } // for sides
            } // for target
        } // for launcher

    }

}
