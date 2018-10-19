/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbc;

import java.util.ArrayList;
import parser.Util;

/**
 *
 * @author rafael
 */
public class Value {

    private final Column column;
    private Object value;
    private Double localSimilarity;

    public Value(Column column, Object value) {
        this.column = column;
        this.value = value;
    }

    public Value(Column column) {
        this.column = column;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Column getColumn() {
        return column;
    }

    public Double getLocalSimilarity() {
        localSimilarityCalculation();
        return localSimilarity;
    }

    private void localSimilarityCalculation() {
        Object baseValue = RBC.getInstance().getBaseCase().getValues().get(RBC.getInstance().getColumns().indexOf(column)).value;
        ArrayList<Object> possibleValues = (ArrayList<Object>) RBC.getInstance().getColumns().get(RBC.getInstance().getColumns().indexOf(column)).getPossibleValues();
        Integer mathType = column.getMathType();
        switch (mathType) {
            case 0:
                localSimilarity = numericalDifference(baseValue);
                break;
            case 1:
                localSimilarity = booleanDifference(baseValue);
                break;
            case 2:
                localSimilarity = positionDifference(baseValue, possibleValues);
                break;
            case 3:
                localSimilarity = circularDifference(baseValue, possibleValues);
                break;
        }
    }

    private Double numericalDifference(Object base) {
        return basicCalculation(((Number) base).doubleValue(), ((Number) value).doubleValue(), ((Number) column.getPossibleValues().get(1)).doubleValue(), ((Number) column.getPossibleValues().get(0)).doubleValue());
    }

    private Double booleanDifference(Object base) {
        if (base == null || value == null) {
            return 0.0;
        }
        return base.equals(value) ? 1.0 : 0.0;
    }

    private Double positionDifference(Object base, ArrayList<Object> possibleValues) {
        Integer posBase = Util.findInList(possibleValues, base);
        Integer posCase = Util.findInList(possibleValues, value);
        if (posBase == null || posCase == null) {
            return 0.0;
        }
        return basicCalculation(posBase.doubleValue(), posCase.doubleValue(), (possibleValues.size() - 1), 0);
    }

    private Double circularDifference(Object base, ArrayList<Object> possibleValues) {
        if (Util.findInList(possibleValues, base) == null || Util.findInList(possibleValues, value) == null) {
            return 0.0;
        }
        return basicCalculation(Util.DistanceInList(possibleValues, base, value).doubleValue(), (possibleValues.size() - 1));
    }

    private Double basicCalculation(Double cP, Double cN, Double vMax, Double vMin) {
        return basicCalculation(cP - cN, vMax - vMin);
    }

    private Double basicCalculation(Double cPN, Double vMaxMin) {
        return 1.0 - (Math.abs(cPN) / vMaxMin);
    }
}
