package model;

import java.awt.*;

/**
 * Created by Carioca on 25/11/2016.
 */
public abstract class MyShape {
    public abstract Point getCoord();
    public abstract boolean checkIntersection(Line fire);
}
