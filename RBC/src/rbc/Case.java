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

    private int id;
    private Object goal;
    private List<Object> values;
    
    public Case(){
        values = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getGoal() {
        return goal;
    }

    public void setGoal(Object goal) {
        this.goal = goal;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }
    
    
}
