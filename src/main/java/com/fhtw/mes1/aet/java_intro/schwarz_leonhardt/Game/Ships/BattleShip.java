package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;

import java.util.List;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 17.08.15
 */
public abstract class BattleShip {

    private int shipId;
    private boolean destroyed = false;
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

    final public void Destroy() {
        destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
