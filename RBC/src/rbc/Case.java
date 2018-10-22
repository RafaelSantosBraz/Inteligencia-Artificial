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
public class Case {

    private Integer id;
    private Object goal;
    private final List<Value> values;
    private Double globalSimilarity;

    public Case(Integer id, Object goal) {
        this.id = id;
        this.goal = goal;
        values = new ArrayList<>();
    }

    public Case() {
        values = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public Object getGoal() {
        return goal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGoal(Object goal) {
        this.goal = goal;
    }

    public List<Value> getValues() {
        return values;
    }

    public Boolean addValue(Value value) {
        return values.add(value);
    }

    public Double getGlobalSimilarity() {
        globalSimilarityCalculation();
        return globalSimilarity;
    }

    private void globalSimilarityCalculation() {
        Integer weights = 0;
        globalSimilarity = 0.0;
        for (Value t : values) {
            globalSimilarity += (t.getLocalSimilarity() * t.getColumn().getWeight());
            weights += t.getColumn().getWeight();
        }
        globalSimilarity /= weights.doubleValue();
    }

    public Boolean addValues(ArrayList<Value> values){
        return this.values.addAll(values);
    }
    
    @Override
    public String toString() {
        String vals = "";
        for (Value t: this.values){
            vals += t.getValue();
        }
        return id + ";" + goal + ";" + vals;
    }

}
