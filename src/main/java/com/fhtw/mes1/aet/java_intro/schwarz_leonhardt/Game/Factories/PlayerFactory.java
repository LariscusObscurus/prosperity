package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Factories;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.Player;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.BattleField;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ConsolePlayer;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 19.08.15
 */
public class PlayerFactory {

    private static int counter = 1;

    public static Player getNewPlayer(String playerType) throws AddShipException {
        switch (playerType) {
            case "ConsolePlayer":
                String name = "player" + counter;
                counter++;
                Player rv = new ConsolePlayer(name);
                BattleField battleField = new BattleField(rv, 7);
                List<Integer> params = Arrays.asList(2,2,1,1);
                BattleShip battleShip = BattleshipFactory.getBattleship("xy_length_battleship", params);
                battleField.addShip(battleShip.getStartCoordinate(), battleShip);
                rv.setBattleField(battleField);
                return rv;
            case "SocketPlayer":
            default:
                throw new NotImplementedException();
        }
    }
}
