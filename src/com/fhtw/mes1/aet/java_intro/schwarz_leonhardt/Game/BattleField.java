package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.Player;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 17.08.15
 */
public class BattleField {

    private Map<Coordinate, BattleShip> ships = new HashMap<>();
    private int battleFieldSize;
    private Player player;

    public BattleField(Player player, int battleFieldSize) {
        this.battleFieldSize = battleFieldSize;
        this.player = player;
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
        if (allShipsDestroyed()) {
            player.notifyVictory(coordinate);
            return false;
        }
        BattleShip ship = ships.get(coordinate);
        if (ship == null) {
            player.notifyMissed(coordinate);
            return false;
        }
        boolean hit = ship.isHit(coordinate);
        if (hit) {
            ships.remove(coordinate);
            player.notifyHit(coordinate);
        }
        if (hit && ship.isDestroyed())
            player.notifyKill(coordinate);
        return hit;
    }

    public boolean allShipsDestroyed() {
        return (ships.size() == 0);
    }

}
