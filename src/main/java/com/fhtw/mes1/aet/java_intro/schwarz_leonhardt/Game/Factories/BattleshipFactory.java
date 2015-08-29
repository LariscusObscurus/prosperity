package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Factories;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.XYLengthBattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.FileHandling.DataTypes.ShipParameters;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 18.08.15
 */
public class BattleshipFactory {

    public static BattleShip getBattleship(ShipParameters params) throws AddShipException {
        switch (params.getShipType()) {
            case "xy_length_battleship":
                if (params.getTypeParams().size() != 4)
                    throw new AddShipException("Config most likely malformed!");
                try {
                    Coordinate start = new Coordinate(params.getTypeParams().get(0), params.getTypeParams().get(1));
                    int lengthX = params.getTypeParams().get(2);
                    int lengthY = params.getTypeParams().get(3);
                    return new XYLengthBattleShip(0, lengthX, lengthY, start);
                } catch (IndexOutOfBoundsException ex) {
                    throw new AddShipException("Config most likely malformed!", ex);
                }
            default:
                throw new AddShipException("Unknown ship type.");
        }
    }

}
