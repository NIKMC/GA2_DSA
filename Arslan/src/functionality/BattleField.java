package functionality;

import model.*;

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

        ArrayList<MyShape> obstacles = (ArrayList<MyShape>) fileReader.readerObstaclesCircle();
        obstacles.addAll( (ArrayList<MyShape>) fileReader.readerObstaclesRectangle() );
        ArrayList<RocketLauncherUltimateNitroTurboBoostSuperSpace3000> launchers = (ArrayList<RocketLauncherUltimateNitroTurboBoostSuperSpace3000>) fileReader.readerRocketLauncher();
        ArrayList<MyRectangle> targets = (ArrayList<MyRectangle>) fileReader.readerTargets();

        for(RocketLauncherUltimateNitroTurboBoostSuperSpace3000 launcher : launchers){
            for(MyRectangle target : targets){
                boolean underAttack = false;
                LinkedList<Line> targetSides = target.getObservableSides(launcher);
                for (int i = 0; i < targetSides.size() && !underAttack; i++) {

                    Line tl = targetSides.get(i);
                    if(tl.getStart().getX() == tl.getFinish().getX()){ // vertical

                        int x = (int) tl.getStart().getX();
                        for (int y = (int) tl.getStart().getY(); y < tl.getFinish().getY() && !underAttack; y++) {

                            Line shootLine = new Line(launcher.getLocation(), new Point(x, y));
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

                            Line shootLine = new Line(launcher.getLocation(), new Point(x, y));
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

        } // for launcher !!

    }

}
