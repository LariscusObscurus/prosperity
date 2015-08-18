package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.BattleField;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ValueObjects.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces.IGameListener;

/**
 * Created by leonhardt on 17.08.15.
 */
public abstract class Player implements IGameListener {
    private String name;
    private BattleField battleField;

    public abstract Coordinate nextGuess();
}
