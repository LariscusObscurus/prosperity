package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Players.Player;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.BattleShip;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 17.08.15
 */
public class BattleField {

    private Map<Coordinate, BattleShip> ships;
    private int battleFieldSize;
    private Player player;

    public BattleField(Player player, int battleFieldSize) {
        this(player, battleFieldSize, new HashMap<>());
    }

    public BattleField(Player player, int battleFieldSize, Map<Coordinate, BattleShip> shipMap) {
        this.battleFieldSize = battleFieldSize;
        this.player = player;
        this.ships = shipMap;
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
        if (ship == null) {
            player.notifyMissed(coordinate);
            return false;
        }

        boolean hit = ship.isHit(coordinate);

        if (ship.isDestroyed()) {
            ships.remove(coordinate);

            if (allShipsDestroyed()) {
                player.notifyVictory(coordinate);
                return true;
            }

            player.notifyKill(coordinate);

        } else if (hit) {
            ships.remove(coordinate);
            player.notifyHit(coordinate);
        }

        return hit;
    }

    public boolean allShipsDestroyed() {
        return (ships.size() == 0);
    }

}
