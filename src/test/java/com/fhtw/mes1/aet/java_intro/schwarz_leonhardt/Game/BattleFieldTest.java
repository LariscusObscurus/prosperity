package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.AbstractClasses.Player;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.*;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 20.08.15
 */
public class BattleFieldTest {

    @Test
    public void testAddShip() throws Exception {

        Player mockedPlayer = mock(Player.class);

        BattleShip mockedShip = mock(BattleShip.class);
        List<Coordinate> testCoordinates = new ArrayList<>(Arrays.asList(
                new Coordinate(1, 1),
                new Coordinate(1, 2)
        ));

        when(mockedShip.getCoordinateList()).thenReturn(testCoordinates);

        Map<Coordinate, BattleShip> testMap = new HashMap<>();
        BattleField testBattleField = new BattleField(mockedPlayer, 7, testMap);
        testBattleField.addShip(new Coordinate(1,1),mockedShip);

        Assert.assertEquals(mockedShip, testMap.get(new Coordinate(1, 1)));
        Assert.assertEquals(mockedShip, testMap.get(new Coordinate(1,2)));

    }

    @Test(expected = AddShipException.class)
    public void testAddShipThrowsNullPointerException() throws AddShipException {

        Player mockedPlayer = mock(Player.class);
        BattleField testBattleField = new BattleField(mockedPlayer, 7);
        testBattleField.addShip(new Coordinate(9,0), null);
    }

    @Test
    public void testIsHit() throws Exception {

    }

    @Test
    public void testAllShipsDestroyed() throws Exception {

    }
}