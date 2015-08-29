package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Players;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        //System Console does not work in my IDE so this approach was used instead
        if (this.getName() == null)
            throw new NullPointerException("Name was null");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("%s Enter Guess -> ", this.getName());
        String guess = br.readLine();
        guess = guess.replaceAll("\\s+", "");

        if (guess.length() != 2)
            throw new IOException("Invalid Input.");

        int x = Character.getNumericValue(guess.charAt(0));
        int y = Character.getNumericValue(guess.charAt(1));
        if (x > 0 && y > 0)
            return new Coordinate(x, y);

        throw new IOException("Invalid input");
    }

}
