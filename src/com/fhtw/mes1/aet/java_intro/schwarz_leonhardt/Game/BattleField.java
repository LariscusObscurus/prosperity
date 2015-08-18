package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ValueObjects.Coordinate;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by leonhardt on 17.08.15.
 */
public class BattleField implements Observer {

    private Map<Coordinate, BattleShip> ships = new HashMap<>();
    private int battleFieldSize;

    public BattleField(int battleFieldSize) {
        this.battleFieldSize = battleFieldSize;
    }

    public void addShip(Coordinate startCoordinate, BattleShip battleShip) throws AddShipException {
        try {

            ships.put(startCoordinate, battleShip);
            battleShip.getCoordinateList()
                    .stream()
                    .forEach(coordinate -> ships.put(coordinate, battleShip));

        } catch (NullPointerException ex) {
            throw new AddShipException("Adding Ship failed", ex);
        }
    }

    public boolean isHit(Coordinate coordinate) {
        BattleShip ship = ships.get(coordinate);
        return ship.isHit(coordinate);
    }

    public boolean allShipsDestroyed() {
        return (ships.size() == 0);
    }


    public void update(Observable observable, Object o) {

    }
}
