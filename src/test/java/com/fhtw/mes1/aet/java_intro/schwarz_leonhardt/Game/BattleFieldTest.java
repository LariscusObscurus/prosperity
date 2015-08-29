package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions.AddShipException;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Players.Player;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.BattleShip;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.BattleShipHealthTracker;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships.XYLengthBattleShip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 20.08.15
 */
public class BattleFieldTest {

    private Player mockedPlayer;
    private BattleShip mockedShip;

    @Before
    public void setUp() throws Exception {

        BattleShip ship = new XYLengthBattleShip(0, 2, 2, new Coordinate(5, 5));
        BattleShipHealthTracker mockedTracker = mock(BattleShipHealthTracker.class);
        ship.setBattleShipHealthTracker(mockedTracker);

        mockedPlayer = mock(Player.class);

        //Mockito can not mock final methods.
        //So for isHit we have to use a real object instead by using "Mockito.spy".
        mockedShip = Mockito.spy(ship);

        when(mockedTracker.isHit(isA(Coordinate.class))).thenAnswer(new Answer<Object>() {

            private int counter = 0;
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {

                Coordinate arg = (Coordinate) invocationOnMock.getArguments()[0];

                if (arg.equals(new Coordinate(1, 2)) || arg.equals(new Coordinate(1, 1))) {
                    counter++;
                    if (counter == 2) {
                        mockedShip.Destroy();
                        counter = 0;
                    }
                    return true;
                }

                return false;
            }
        });

        List<Coordinate> testCoordinates = new ArrayList<>(Arrays.asList(
                new Coordinate(1, 1),
                new Coordinate(1, 2)
        ));

        when(mockedShip.getCoordinateList()).thenReturn(testCoordinates);
        when(mockedShip.getStartCoordinate()).thenReturn(testCoordinates.get(0));

    }

    @Test
    public void testAddShip() throws Exception {
        Map<Coordinate, BattleShip> testMap = new HashMap<>();
        BattleField testBattleField = new BattleField(mockedPlayer, 7, testMap);
        testBattleField.addShip(new Coordinate(1,1),mockedShip);

        Assert.assertEquals(mockedShip, testMap.get(new Coordinate(1, 1)));
        Assert.assertEquals(mockedShip, testMap.get(new Coordinate(1, 2)));

    }

    @Test(expected = AddShipException.class)
    public void testAddShipThrowsNullPointerException() throws AddShipException {
        BattleField testBattleField = new BattleField(mockedPlayer, 7);
        testBattleField.addShip(new Coordinate(9,0), null);
    }

    @Test
    public void testIsHitNotifiesHit() throws Exception {
        BattleField testBattleField = new BattleField(mockedPlayer, 7);
        testBattleField.addShip(mockedShip.getStartCoordinate(), mockedShip);

        boolean result = testBattleField.isHit(new Coordinate(1, 2));
        Assert.assertTrue(result);
        verify(mockedPlayer).notifyHit(any());
    }

    @Test
    public void testIsHitNotifiesKill() throws Exception {

        Map<Coordinate, BattleShip> testMap = new HashMap<>();
        BattleField testBattleField = new BattleField(mockedPlayer, 7, testMap);

        //Second ship to notify Kill instead of victory.
        BattleShip ship = new XYLengthBattleShip(0, 2, 2, new Coordinate(5, 5));

        testBattleField.addShip(ship.getStartCoordinate(), ship);
        testBattleField.addShip(mockedShip.getStartCoordinate(), mockedShip);

        boolean result;
        result = testBattleField.isHit(new Coordinate(1, 2));
        result = testBattleField.isHit(new Coordinate(1, 1));
        verify(mockedPlayer).notifyKill(any());
    }


    @Test
    public void testIsHitNotifiesVictory() throws Exception {
        Map<Coordinate, BattleShip> testMap = new HashMap<>();
        BattleField testBattleField = new BattleField(mockedPlayer, 7, testMap);

        testBattleField.addShip(mockedShip.getStartCoordinate(), mockedShip);
        boolean result;
        result = testBattleField.isHit(new Coordinate(1, 2));
        result = testBattleField.isHit(new Coordinate(1, 1));

        verify(mockedPlayer).notifyVictory(any());

    }

    @Test
    public void testIsHitNotifiesMiss() throws Exception {
        Map<Coordinate, BattleShip> testMap = new HashMap<>();
        BattleField testBattleField = new BattleField(mockedPlayer, 7, testMap);

        testBattleField.addShip(mockedShip.getStartCoordinate(), mockedShip);

        boolean result = testBattleField.isHit(new Coordinate(1, 9));
        verify(mockedPlayer).notifyMissed(any());

    }

    @Test
    public void testAllShipsDestroyed() throws Exception {
        Map<Coordinate, BattleShip> testMap = new HashMap<>();
        BattleField testBattleField = new BattleField(mockedPlayer, 7, testMap);

        boolean result = testBattleField.allShipsDestroyed();
        Assert.assertTrue(result);
    }
}