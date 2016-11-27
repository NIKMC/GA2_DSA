package functionality;

import model.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
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

                    Line tl = targetSides.get(i);
                    if(tl.getStart().getX() == tl.getFinish().getX()){ // vertical

                        int x = (int) tl.getStart().getX();
                        for (int y = (int) tl.getStart().getY(); y < tl.getFinish().getY() && !underAttack; y++) {
                            int pixelColor = new Color(255, 34, 21).getRGB();
                            Line shootLine = new Line(launcher.getLocation(), new Point(x, y), image, pixelColor);
                            boolean clear = true;
                            for (int j = 0; j < obstacles.size() && clear; j++) {
                                clear = !obstacles.get(j).checkIntersection(shootLine);
                            } // for obstacles
                            underAttack = clear;
                        } // for pixels in side
                    } // if
                    else{ // horisontal
                        int y = (int) tl.getStart().getY();
                        for (int x = (int) tl.getStart().getX(); x < tl.getFinish().getX() && !underAttack; x++) {
                            int pixelColor = new Color(255, 34, 21).getRGB();
                            Line shootLine = new Line(launcher.getLocation(), new Point(x, y), image, pixelColor);
                            boolean clear = true;
                            for (int j = 0; j < obstacles.size() && clear; j++) {
                                clear = !obstacles.get(j).checkIntersection(shootLine);
                            } // for obstacles
                            underAttack = clear;
                        } // for pixels in side
                    } // else

                } // for sides

                if (underAttack) launcher.getUnderStrike().add(target);

            } // for target
            System.out.println("RocketLauncher "+ launcher.getLocation().toString());
            for(MyRectangle target: launcher.getUnderStrike()){
                System.out.println(target.getLeftTop().toString());
            }

        } // for launcher
	try {
            ImageIO.write(image, "png", resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
