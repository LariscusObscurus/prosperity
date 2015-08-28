package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.FileHandling;

import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.FileHandling.DTO.ShipConfigDTO;
import com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.FileHandling.Exceptions.MalformedConfigException;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leonhardt on 18.08.15.
 */
public class ConfigReader {

    private CSVReader configReader;

    public ConfigReader(CSVReader configReader) {
        this.configReader = configReader;
    }

    public ShipConfigDTO readNext() throws IOException, MalformedConfigException {
        String[] line = configReader.readNext();
        return mapToDTO(line);
    }

    public CSVReader getConfigReader() {
        return configReader;
    }

    private ShipConfigDTO mapToDTO(String[] splitCSVInput) throws MalformedConfigException {

        if (splitCSVInput == null || splitCSVInput.length == 0) {
            throw new MalformedConfigException("Malformed Config file.");
        }

        ShipConfigDTO rv = new ShipConfigDTO();
        rv.setShipType(splitCSVInput[0]);

        List<Integer> typeParams =  Stream.of(splitCSVInput).skip(1)
                                        .map(t -> Integer.parseInt(t))
                                        .collect(Collectors.toList());

        rv.setTypeParams(typeParams);
        return rv;
    }
}
