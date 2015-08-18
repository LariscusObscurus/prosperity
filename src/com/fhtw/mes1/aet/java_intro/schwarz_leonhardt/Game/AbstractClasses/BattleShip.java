package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.BattleShipHealthTracker;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ValueObjects.Coordinate;

import java.util.List;

/**
 * Created by leonhardt on 17.08.15.
 */
public abstract class BattleShip {

    private int shipId;
    private Coordinate startCoordinate;
    private BattleShipHealthTracker battleShipHealthTracker;

    public BattleShip(int shipId, Coordinate startCoordinate) {
        this.shipId = shipId;
        this.startCoordinate = startCoordinate;
        this.battleShipHealthTracker = new BattleShipHealthTracker(this);
    }

    public Coordinate getStartCoordinate() {
        return startCoordinate;
    }

    public abstract List<Coordinate> getCoordinateList();

    final public boolean isHit(Coordinate rel) {
        return battleShipHealthTracker.isHit(rel);
    }

    final public int getShipId() {
        return shipId;
    }


}
