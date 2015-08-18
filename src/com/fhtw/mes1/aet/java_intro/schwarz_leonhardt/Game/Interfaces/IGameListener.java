package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ValueObjects.Coordinate;

/**
 * Created by leonhardt on 17.08.15.
 */
public interface IGameListener {
    void notifyHit(Coordinate coordinate);

    void notifyMissed(Coordinate coordinate);

    void notifyVictory(Coordinate coordinate);
}
