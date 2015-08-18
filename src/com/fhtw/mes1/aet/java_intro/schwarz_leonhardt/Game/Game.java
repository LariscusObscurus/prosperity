package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by leonhardt on 18.08.15.
 */
public class Game {

    private Player player1;
    private Player player2;

    public void setPlayer1(Player player) {
        this.player1 = player;
    }

    public void setPlayer2(Player player) {
        this.player2 = player;
    }

    public void start() {
        throw new NotImplementedException();
    }

}
