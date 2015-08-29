package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Players;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.BattleField;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.EventType;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces.IGameListener;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces.IGameObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 17.08.15
 */
public abstract class Player implements IGameListener {
    List<IGameObserver> observerList = new ArrayList<>();
    private String name;
    private BattleField battleField;

    protected Player(String name) {
        this.name = name;
    }

    public abstract Coordinate nextGuess() throws IOException;

    public String getName() {
        return name;
    }

    @Override
    public void notifyHit(Coordinate coordinate) {
        observerList.forEach(n -> n.update(this, EventType.Hit, coordinate));
    }

    @Override
    public void notifyMissed(Coordinate coordinate) {

        observerList.forEach(n -> n.update(this, EventType.Miss, coordinate));
    }

    @Override
    public void notifyVictory(Coordinate coordinate) {

        observerList.forEach(n -> n.update(this, EventType.Victory, coordinate));
    }

    @Override
    public void notifyKill(Coordinate coordinate) {

        observerList.forEach(n -> n.update(this, EventType.Kill, coordinate));
    }

    @Override
    public void addObserver(IGameObserver observer) {
        observerList.add(observer);
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }
}
