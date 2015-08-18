package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ValueObjects.Coordinate;

import java.util.*;

/**
 * Created by leonhardt on 18.08.15.
 */
public class BattleShipHealthTracker extends Observable{

    private List<Coordinate> coordinateList;
    BattleShip ship;
    boolean lazyLoading = false;

    public BattleShipHealthTracker(BattleShip ship) {
        this.ship = ship;
    }

    public boolean isHit(Coordinate coordinate)
    {
        if (!lazyLoading) //Lazy loading so lengthX and Y make sense as members in XYLengthBattleShip
            this.coordinateList = ship.getCoordinateList();

        if (coordinateList == null)
            return false;

        boolean rv = coordinateList.removeIf(t -> t.equals(coordinate));
        if (coordinateList.isEmpty())
            notifyObservers();
        return rv;
    }
}
