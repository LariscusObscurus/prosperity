package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.XYLengthBattleShip;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 20.08.15
 */
public class XYLengthBattleShipTest {

    @Test
    public void testGetCoordinateList() {
        XYLengthBattleShip testShip = new XYLengthBattleShip(0, 2, 2, new Coordinate(3,3));
        List<Coordinate> result = testShip.getCoordinateList();
        Assert.assertTrue(result.contains(new Coordinate(3, 3)));
        Assert.assertTrue(result.contains(new Coordinate(4, 3)));
        Assert.assertTrue(result.contains(new Coordinate(3, 4)));
        Assert.assertTrue(result.contains(new Coordinate(4, 4)));

        testShip = new XYLengthBattleShip(0, 3, 1, new Coordinate(3,6));
        result = testShip.getCoordinateList();
        Assert.assertTrue(result.contains(new Coordinate(3, 6)));
        Assert.assertTrue(result.contains(new Coordinate(4, 6)));
        Assert.assertTrue(result.contains(new Coordinate(5, 6)));

        testShip = new XYLengthBattleShip(0, 1, 3, new Coordinate(4,4));
        result = testShip.getCoordinateList();
        Assert.assertTrue(result.contains(new Coordinate(4, 4)));
        Assert.assertTrue(result.contains(new Coordinate(4, 5)));
        Assert.assertTrue(result.contains(new Coordinate(4, 6)));

        testShip = new XYLengthBattleShip(0, 0, 0, new Coordinate(0,0));
        result = testShip.getCoordinateList();
        Assert.assertTrue(result.contains(new Coordinate(0, 0)));

        testShip = new XYLengthBattleShip(0, -1, -3, new Coordinate(0,0));
        result = testShip.getCoordinateList();
        Assert.assertTrue(result.contains(new Coordinate(0, 0)));
    }
}