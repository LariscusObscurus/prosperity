package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;

import java.util.List;
import java.util.Observable;

/**
 * This class holds the current amount of health a ship has left,
 * and where it was hit. It also provides a method to reduce the
 * ships health if it was hit.
 *
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @see BattleShip
 * @see Observable
 * @since 18.08.15
 */
public class BattleShipHealthTracker {

    BattleShip ship;
    boolean lazyLoading = false;
    /**
     * De
     */
    private List<Coordinate> coordinateList;

    public BattleShipHealthTracker(BattleShip ship) {
        this.ship = ship;
    }

    /**
     * Checks whether the ship was hit and keeps track of the ship
     * parts that where already hit.
     *
     * @param coordinate The coordinate that the opposing player guessed
     * @return True if the ship was successfully damaged
     */
    public boolean isHit(Coordinate coordinate) {
        if (!lazyLoading) { //Lazy loading so lengthX and Y make sense as members in XYLengthBattleShip
            this.coordinateList = ship.getCoordinateList();
            lazyLoading = true;
        }

        if (coordinateList == null)
            return false;

        boolean rv = coordinateList.removeIf(t -> t.equals(coordinate));
        if (coordinateList.isEmpty())
            ship.Destroy();
        return rv;
    }
}
