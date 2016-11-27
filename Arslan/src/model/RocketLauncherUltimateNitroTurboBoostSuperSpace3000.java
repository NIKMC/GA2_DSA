package model;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by NIKMC on 25.11.16.
 */
public class RocketLauncherUltimateNitroTurboBoostSuperSpace3000 {
    private Point location;
    private Double attackAngle;
    private LinkedList<MyRectangle> underStrike;

    public RocketLauncherUltimateNitroTurboBoostSuperSpace3000(Point location, Double attackAngle) {
        this.location = location;
        this.attackAngle = attackAngle;
        this.underStrike = new LinkedList<MyRectangle>();
    }

    public RocketLauncherUltimateNitroTurboBoostSuperSpace3000(Point location) {
        this.location = location;
        this.attackAngle = 30.0; // default
        this.underStrike = new LinkedList<MyRectangle>();
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Double getAttackAngle() {
        return attackAngle;
    }

    public void setAttackAngle(Double attackAngle) {
        this.attackAngle = attackAngle;
    }

    public LinkedList<MyRectangle> getUnderStrike() {
        return underStrike;
    }

    public void setUnderStrike(LinkedList<MyRectangle> underStrike) {
        this.underStrike = underStrike;
    }
}
