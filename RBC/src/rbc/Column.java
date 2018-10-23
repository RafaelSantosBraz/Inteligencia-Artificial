/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class Column {

    private final String name;
    private final Integer mathType;
    private final Integer weight;
    private final List<Object> possibleValues;

    public Column(String name, Integer mathType, Integer weight) {
        this.name = name;
        this.mathType = mathType;
        this.weight = weight;
        possibleValues = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getMathType() {
        return mathType;
    }

    public Integer getWeight() {
        return weight;
    }

    public List<Object> getPossibleValues() {
        return possibleValues;
    }

    public Boolean addPossibleValue(Object value) {
        return possibleValues.add(value);
    }
}
