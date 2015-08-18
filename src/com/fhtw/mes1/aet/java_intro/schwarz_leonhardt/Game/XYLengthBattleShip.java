package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ValueObjects.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonhardt on 18.08.15.
 */
public class XYLengthBattleShip extends BattleShip {

    private int lengthX;
    private int lengthY;

    public XYLengthBattleShip(int shipId, int lengthX, int lengthY, Coordinate startCoordinate) {
        super(shipId, startCoordinate);
        this.lengthX = lengthX;
        this.lengthY = lengthY;
    }

    @Override
    public List<Coordinate> getCoordinateList() {
        ArrayList<Coordinate> out = new ArrayList<>();
        Coordinate startCoordinate = getStartCoordinate();

        if (lengthX == 0 || lengthY == 0)

            for (int j = startCoordinate.getX(); j < (startCoordinate.getX() + this.lengthX); j++) {
                for (int i = startCoordinate.getY(); i < (startCoordinate.getY() + this.lengthY); i++) {
                    out.add(new Coordinate(j, i));
                }
            }
        return out;
    }
}
