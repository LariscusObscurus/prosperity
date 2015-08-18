package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.Player;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ValueObjects.Coordinate;

/**
 * Created by leonhardt on 18.08.15.
 */
public class SocketPlayer extends Player {

    @Override
    public Coordinate nextGuess() {
        return null;
    }

    @Override
    public void notifyHit(Coordinate coordinate) {

    }

    @Override
    public void notifyMissed(Coordinate coordinate) {

    }

    @Override
    public void notifyVictory(Coordinate coordinate) {

    }
}
