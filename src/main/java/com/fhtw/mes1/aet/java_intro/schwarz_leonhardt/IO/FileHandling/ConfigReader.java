package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.FileHandling;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.FileHandling.DataTypes.ShipParameters;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 18.08.15
 */
public class ConfigReader {

    private CSVReader configReader;

    public ConfigReader(CSVReader configReader) {
        this.configReader = configReader;
    }

    public ShipParameters readNext() throws IOException {
        String[] line = configReader.readNext();
        return mapToShipParameters(line);
    }

    public CSVReader getConfigReader() {
        return configReader;
    }

    private ShipParameters mapToShipParameters(String[] splitCSVInput) {

        if (splitCSVInput == null)
        {
            return null;
        }
        ShipParameters rv = new ShipParameters();
        rv.setShipType(splitCSVInput[0]);

        List<Integer> typeParams =  Stream.of(splitCSVInput).skip(1)
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());

        rv.setTypeParams(typeParams);
        return rv;
    }
}
