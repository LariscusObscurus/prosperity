package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Factories;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.XYLengthBattleShip;

import java.util.List;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 18.08.15
 */
public class BattleshipFactory {

    public static BattleShip getBattleship(String shipType, List<Integer> typeParams) throws AddShipException {
        switch (shipType) {
            case "xy_length_battleship":
                if (typeParams.size() != 4)
                    throw new AddShipException("Config most likely malformed!");
                try {
                    Coordinate start = new Coordinate(typeParams.get(0), typeParams.get(1));
                    int lengthX = typeParams.get(2);
                    int lengthY = typeParams.get(3);
                    return new XYLengthBattleShip(0, lengthX, lengthY, start);
                } catch (IndexOutOfBoundsException ex) {
                    throw new AddShipException("Config most likely malformed!", ex);
                }
            default:
                throw new AddShipException("Unknown ship type.");
        }
    }

}
