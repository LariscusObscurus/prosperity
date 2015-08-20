package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 17.08.15
 */
public interface IGameListener {
    void notifyHit(Coordinate coordinate);

    void notifyMissed(Coordinate coordinate);

    void notifyVictory(Coordinate coordinate);

    void notifyKill(Coordinate coordinate);

    void addObserver(IGameObserver observer);
}
