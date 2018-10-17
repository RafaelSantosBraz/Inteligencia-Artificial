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
public class Column {

    private final String name;
    private final Integer mathType;
    private final Integer weight;

    public Column(String name, Integer mathType, Integer weight) {
        this.name = name;
        this.mathType = mathType;
        this.weight = weight;
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
    
}
