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

    }

}
