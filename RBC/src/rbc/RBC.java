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
    private final List<Case> cases;
    private Case baseCase;

    public RBC() {
        columns = new ArrayList<>();
        cases = new ArrayList<>();
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Case> getCases() {
        return cases;
    }

    public Boolean addColumn(Column column) {
        return columns.add(column);
    }

    public Boolean addCase(Case ccase) {
        return cases.add(ccase);
    }

    public Case getBaseCase() {
        return baseCase;
    }

    public void setBaseCase(Case baseCase) {
        this.baseCase = baseCase;
    }

}
