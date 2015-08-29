package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Players;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces.IGameObserver;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 18.08.15
 */
public class SocketPlayer extends Player {

    public SocketPlayer(String name) {
        super(name);
    }

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

    @Override
    public void notifyKill(Coordinate coordinate) {

    }

    @Override
    public void addObserver(IGameObserver observer) {

    }
}
