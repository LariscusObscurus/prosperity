package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.EventType;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 18.08.15
 */
public interface IGameObserver {
    public void update(IGameListener gameListener, EventType event, Coordinate coordinate);
}
