package functionality;

import model.*;

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

        ArrayList<MyShape> obstacles = (ArrayList<MyShape>) fileReader.readerObstaclesCircle(image);
        obstacles.addAll( (ArrayList<MyShape>) fileReader.readerObstaclesRectangle(image) );
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
