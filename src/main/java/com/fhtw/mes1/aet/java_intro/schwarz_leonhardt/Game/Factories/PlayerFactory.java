package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Factories;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.BattleField;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Players.ConsolePlayer;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Players.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 19.08.15
 */
public class PlayerFactory {

    private static int counter = 1;

    public static Player getNewPlayer(String playerType) throws AddShipException {
        switch (playerType) {
            case "ConsolePlayer":
                String name = "Player" + counter;
                counter++;
                Player rv = new ConsolePlayer(name);
                BattleField battleField = new BattleField(rv, 7);
                rv.setBattleField(battleField);
                return rv;
            case "SocketPlayer":
            default:
                throw new NotImplementedException();
        }
    }
}
