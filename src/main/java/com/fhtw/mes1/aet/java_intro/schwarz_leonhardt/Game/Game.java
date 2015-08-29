package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.EventType;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Factories.BattleshipFactory;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces.IGameListener;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Interfaces.IGameObserver;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Players.Player;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.FileHandling.ConfigReader;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.FileHandling.DataTypes.ShipParameters;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 18.08.15
 */
public class Game implements IGameObserver {

    boolean gameEnded = false;
    private Player player1 = null;
    private Player player2 = null;

    public void setPlayer1(Player player) {
        this.player1 = player;
        this.player1.addObserver(this);
    }

    public void setPlayer2(Player player) {
        this.player2 = player;
        this.player2.addObserver(this);
    }

    public void start() {
        if (player1 == null || player2 == null)
            throw new NullPointerException("Not enough players.");

        try {
            addShips(player1);
            addShips(player2);
        } catch (IOException | AddShipException ex) {
            printError(ex.getMessage());
            return;
        }

        Player nextPlayer = player1;
        while (!gameEnded) {
            try {
                NextMove(nextPlayer);
                if (nextPlayer == player1)
                    nextPlayer = player2;
                else
                    nextPlayer = player1;
            } catch (IOException ex) {
                printError(ex.getMessage());
            }

        }
    }

    private void addShips(Player player) throws IOException, AddShipException {
        FileReader fileReader = new FileReader(String.format("%s.csv", player.getName()));

        ConfigReader configReader = new ConfigReader(new CSVReader(fileReader, ';'));

        ShipParameters nextShip;
        while ((nextShip = configReader.readNext()) != null) {
            BattleShip ship = BattleshipFactory.getBattleship(nextShip);
            player.getBattleField().addShip(ship.getStartCoordinate(), ship);
        }
    }

    private void NextMove(Player player) throws IOException {
        Coordinate coordinate = player.nextGuess();
        player.getBattleField().isHit(coordinate);
    }

    @Override
    public void update(IGameListener gameListener, EventType event, Coordinate coordinate) {
        switch (event) {
            case Hit:
                printGuessResult("Hit");
                break;
            case Miss:
                printGuessResult("You missed.");
                break;
            case Kill:
                printGuessResult("Ship destroyed.");
                break;
            case Victory:
                gameEnded = true;
                Player player;

                if (player1 == gameListener)
                    player = player1;
                 else
                    player = player2;

                printGuessResult("Player " + player.getName() + " won the game.");
                break;
        }
    }

    private void printGuessResult(String result) {
        System.out.println(result);
    }

    private void printError(String message) {
        System.out.println(message);
    }
}
