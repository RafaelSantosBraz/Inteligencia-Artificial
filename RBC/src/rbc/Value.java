/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbc;

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
        Integer mathType = column.getMathType();
        switch (mathType) {
            case 0:
                localSimilarity = numericalDifference(baseValue);
                break;
            case 1:
                localSimilarity = booleanDifference(baseValue);
                break;
            case 2:
                localSimilarity = positionDifference(baseValue);
                break;
            case 3:
                localSimilarity = circularDifference(baseValue);
                break;
        }
    }

    private Double numericalDifference(Object base) {
        return 0.0;
    }

    private Double booleanDifference(Object base) {
        return 0.0;
    }

    private Double positionDifference(Object base) {
        return 0.0;
    }

    private Double circularDifference(Object base) {
        return 0.0;
    }
}
