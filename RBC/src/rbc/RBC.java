/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private Double cnf;

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

    public String[] getColumnNames() {
        String names[] = new String[columns.size()];
        for (int c = 0; c < columns.size(); c++) {
            names[c] = columns.get(c).getName();
        }
        return names;
    }

    public Double getCnf() {
        return cnf;
    }

    public void setCnf(Double cnf) {
        this.cnf = cnf;
    }

    public ArrayList<Case> getCasesByCnf() {
        ArrayList<Case> result = new ArrayList<>();
        cases.forEach((t) -> {
            if (t.getCalcGlobalSimilarity() >= cnf) {
                result.add(t);
            }
        });
        result.sort((o1, o2) -> {
            if (o1.getGlobalSimilarity() < o2.getGlobalSimilarity()) {
                return 1;
            }
            if (o1.getGlobalSimilarity() > o2.getGlobalSimilarity()) {
                return -1;
            }
            return 0;
        });
        return result;
    }

    public Case findCaseById(Integer id) {
        for (Case t : cases) {
            if (Objects.equals(t.getId(), id)) {
                return t;
            }
        }
        return null;
    }
}
