package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.Player;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.ConsoleIOHandler;

import java.io.IOException;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 17.08.15
 */
public class ConsolePlayer extends Player {


    public ConsolePlayer(String name) {
        super(name);
    }

    @Override
    public Coordinate nextGuess() throws IOException {
        return ConsoleIOHandler.getNextGuess(this.getName());
    }

}
