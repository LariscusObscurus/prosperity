package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Ships;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.DataTypes.Coordinate;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 20.08.15
 */
public class BattleShipHealthTrackerTest {

    @Test
    public void testIsHit() {
        BattleShip mockedShip = mock(BattleShip.class);
        List<Coordinate> testCoordinates = new ArrayList<>(Arrays.asList(
                new Coordinate(1,1),
                new Coordinate(1,2)
        ));

        when(mockedShip.getCoordinateList()).thenReturn(testCoordinates);

        BattleShipHealthTracker testInstance = new BattleShipHealthTracker(mockedShip);
        boolean result;

        result = testInstance.isHit(new Coordinate(3,3));
        Assert.assertFalse(result);

        testInstance.isHit(new Coordinate(1, 1));
        result = testInstance.isHit(new Coordinate(1,2));
        Assert.assertTrue(result);

    }


}