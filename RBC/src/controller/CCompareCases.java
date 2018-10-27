/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import rbc.Case;
import rbc.Column;
import rbc.RBC;
import view.CompareCases;

/**
 *
 * @author rafael
 */
public class CCompareCases {

    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static CCompareCases instance;

    public static CCompareCases getInstance() {
        if (instance == null) {
            instance = new CCompareCases();
        }
        return instance;
    }
    //</editor-fold>

    private CompareCases form;

    public CCompareCases() {
        form = new CompareCases(this);
    }

    private void setCollumsData() {
        ArrayList<Column> columns = (ArrayList<Column>) RBC.getInstance().getColumns();
        String names[] = RBC.getInstance().getColumnNames();
        setFirstTable(columns, names);
        setSecondTable();
        form.jPanel3.setLayout(new FlowLayout(1));
        form.jPanel3.doLayout();
        form.jPanel3.repaint();
    }

    private void setFirstTable(ArrayList<Column> columns, String names[]) {
        form.jTable1.setModel(new DefaultTableModel(names, 1));
        for (int c = 0; c < columns.size(); c++) {
            Object value = RBC.getInstance().getBaseCase().getValues().get(c).getValue();
            if (value == null) {
                value = "?";
            }
            form.jTable1.setValueAt(value, 0, c);
        }
        form.jTable1.setEnabled(false);
    }

    private void setSecondTable() {
        String names[] = {"ID", "Objetivo", "Similaridade"};
        ArrayList<Case> casesByCnf = RBC.getInstance().getCasesByCnf();
        form.jTable2.setModel(new DefaultTableModel(names, casesByCnf.size()) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        }
        );
        casesByCnf.forEach((t) -> {
            form.jTable2.setValueAt(t.getId(), casesByCnf.indexOf(t), 0);
            form.jTable2.setValueAt(t.getGoal(), casesByCnf.indexOf(t), 1);
            form.jTable2.setValueAt(t.getGlobalSimilarity(), casesByCnf.indexOf(t), 2);
        });
    }

    public void createForm() {
        setCollumsData();
        form.setVisible(true);
    }

    public void renewForm() {
        form.dispose();
        form = new CompareCases(this);
        setCollumsData();
        form.setVisible(true);
    }

    public void showForm() {
        form.setVisible(true);
    }

    public void closeForm() {
        form.setVisible(false);
    }

    public void goBack() {
        form.setVisible(false);
        CDataCollector.getInstance().showForm();
    }
    
    public void nextStep(){
                
    }
}
