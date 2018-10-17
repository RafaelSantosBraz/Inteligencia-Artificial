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
public class RBC {

    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static RBC instance;

    public static RBC getInstance() {
        if (instance == null) {
            instance = new RBC();
        }
        return instance;
    }
    //</editor-fold>

    private final List<Column> columns;

    public RBC() {
        columns = new ArrayList<>();
    }

    public List<Column> getColumns() {
        return columns;
    }
    
    public Boolean addColumn(Column column){
        return columns.add(column);
    }
}
