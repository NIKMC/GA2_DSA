package functionality;

import model.MyCircle;
import model.MyRectangle;
import model.RocketLauncherUltimateNitroTurboBoostSuperSpace3000;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NIKMC on 25.11.16.
 */
public class Reader {

    private static final String FILE_OBSTACLE_RECTANGLE = "obstaclesR.txt";
    private static final String FILE_OBSTACLE_CIRCLE = "obstaclesC.txt";
    private static final String FILE_ROCKETLAUNCHER = "RocketLauncher.txt";
    private static final String FILE_TARGETS = "targets.txt";


    private ArrayList<String> patternReader(String path){

        BufferedReader br = null;
        ArrayList<String> listString = new ArrayList<>();
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(path));

            while ((sCurrentLine = br.readLine()) != null) {
                listString.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return listString;
    }


    public List<Shape> readerObstaclesCircle(BufferedImage image) {
        List<Shape> listCircles = new ArrayList<>();
        List<String> strings = patternReader(FILE_OBSTACLE_CIRCLE);
        for(String string : strings){
            listCircles.add((Shape) new MyCircle(new Point(Integer.parseInt(string.substring(0, string.indexOf(" "))),
                                         Integer.parseInt(string.substring(string.indexOf(" ") + 1, string.lastIndexOf(" ")))),
                    Integer.parseInt(string.substring(string.lastIndexOf(" ") + 1)) ));
        }
        return listCircles;
    }

    public List<Shape> readerObstaclesRectangle(BufferedImage image) {
        List<Shape> listRectangles = new ArrayList<>();
        List<String> strings = patternReader(FILE_OBSTACLE_RECTANGLE);
        for(String string : strings){
            listRectangles.add((Shape) new MyRectangle(new Point(Integer.parseInt(string.substring(0, string.indexOf(" "))),
                    Integer.parseInt(string.substring(string.indexOf(" ") + 1, string.lastIndexOf(" ")))),
                    Integer.parseInt(string.substring(string.lastIndexOf(" ") + 1, string.lastIndexOf("-"))),
                    Integer.parseInt(string.substring(string.lastIndexOf("-") + 1))),
                    image);
        }
        return listRectangles;
    }

    public List<RocketLauncherUltimateNitroTurboBoostSuperSpace3000> readerRocketLauncher(BufferedImage image) {
        List<RocketLauncherUltimateNitroTurboBoostSuperSpace3000> listRockets = new ArrayList<>();

        List<String> strings = patternReader(FILE_ROCKETLAUNCHER);
        for(String string : strings){
//            listRockets.add(new RocketLauncherUltimateNitroTurboBoostSuperSpace3000(
//                    new Point(Integer.parseInt(string.substring(0, string.lastIndexOf(" "))),
//                    Integer.parseInt(string.substring(string.lastIndexOf(" ") + 1)))));
        }
        return listRockets;
    }

    public List<MyRectangle> readerTargets(BufferedImage image) {
        List<MyRectangle> listRectangles = new ArrayList<>();
        List<String> strings = patternReader(FILE_TARGETS);
        for(String string : strings){
            listRectangles.add(new MyRectangle(new Point(Integer.parseInt(string.substring(0, string.indexOf(" "))),
                    Integer.parseInt(string.substring(string.indexOf(" ") + 1, string.lastIndexOf(" ")))),
                    Integer.parseInt(string.substring(string.lastIndexOf(" ") + 1, string.lastIndexOf("-"))),
                    Integer.parseInt(string.substring(string.lastIndexOf("-") + 1))),
                    image);
        }
        return listRectangles;
    }
}
