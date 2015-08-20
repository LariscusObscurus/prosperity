package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt;


import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Factories.PlayerFactory;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Game;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.ConsoleIOHandler;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, AddShipException {

        Game game = new Game();
        game.setPlayer1(PlayerFactory.getNewPlayer("ConsolePlayer"));
        game.setPlayer2(PlayerFactory.getNewPlayer("ConsolePlayer"));
        try {
            game.start();
        } catch (NullPointerException ex)
        {
            ConsoleIOHandler.printError(ex.getMessage());
        }
    }
}
