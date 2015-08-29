package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.IO.FileHandling.DataTypes;

import java.util.List;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 28.08.15
 */
public class ShipParameters {

    private String shipType;
    private List<Integer> typeParams;

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public List<Integer> getTypeParams() {
        return typeParams;
    }

    public void setTypeParams(List<Integer> typeParams) {
        this.typeParams = typeParams;
    }
}
