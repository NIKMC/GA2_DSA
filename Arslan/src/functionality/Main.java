package functionality;

import model.MyCircle;
import model.MyRectangle;
import model.RocketLauncherUltimateNitroTurboBoostSuperSpace3000;

/**
 * Created by NIKMC on 25.11.16.
 */
public class Main {

    public static void main(String[] args){
        Reader fileReader = new Reader();
        for(MyCircle circle : fileReader.readerObstaclesCircle()){
            System.out.println(circle.getCenter().x + " | " + circle.getCenter().y + " | " + circle.getRadius());
        }
        for(MyRectangle rectangle : fileReader.readerObstaclesRectangle())
        System.out.println(rectangle.getLeftTop().x + " | " + rectangle.getLeftTop().y + " | " +
                rectangle.getWidth() + " | " + rectangle.getHeight());

        for (RocketLauncherUltimateNitroTurboBoostSuperSpace3000 rocket : fileReader.readerRocketLauncher())
        System.out.println(rocket.getLocation().x + " | " + rocket.getLocation().y );

        for(MyRectangle rectangle : fileReader.readerTargets())
        System.out.println(rectangle.getLeftTop().x + " | " + rectangle.getLeftTop().y + " | " +
                rectangle.getWidth() + " | " + rectangle.getHeight());

    }
}
