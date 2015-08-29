package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.FileHandling;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.FileHandling.DataTypes.ShipParameters;
import com.opencsv.CSVReader;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 28.08.15
 */
public class ConfigReaderTest {

    private CSVReader mockReader;
    private ConfigReader testReader;

    @Before
    public void setUp() throws IOException {
        mockReader = mock(CSVReader.class);

        //Mock Config using two config lines.
        when(mockReader.readNext()).thenAnswer(new Answer() {

            private int count = 0;

            public Object answer(InvocationOnMock invocation) {
                String[] rv;

                if (count  == 0) {
                    rv = new String[]{"xy_length_battleship","2","2","1","1"};
                } else {
                    rv = new String[]{"circular_battleship","3","3","2","2"};
                }

                count = (count + 1) % 2;

                return rv;

            }

        });

        testReader = new ConfigReader(mockReader);
    }

    @Test
    public void testGetConfigReader() throws Exception {
        Assert.assertEquals(mockReader, testReader.getConfigReader());
    }

    @Test
    public void testReadNext() throws Exception {
        ShipParameters result =  testReader.readNext();

        Assert.assertEquals("xy_length_battleship", result.getShipType());

        List<Integer> expectedList =Arrays.asList(2,2,1,1);
        Assert.assertEquals(expectedList, result.getTypeParams());

        result =  testReader.readNext();

        Assert.assertEquals("circular_battleship", result.getShipType());

        expectedList =Arrays.asList(3,3,2,2);
        Assert.assertEquals(expectedList, result.getTypeParams());

    }
}