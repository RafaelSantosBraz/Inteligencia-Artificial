/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rbc.Case;
import rbc.Column;
import rbc.RBC;
import view.SimilarityResult;

/**
 *
 * @author rafael
 */
public class CSimilarityResult {

    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static CSimilarityResult instance;

    public static CSimilarityResult getInstance() {
        if (instance == null) {
            instance = new CSimilarityResult();
        }
        return instance;
    }
    //</editor-fold>

    private SimilarityResult form;

    public CSimilarityResult() {
        form = new SimilarityResult(this);
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
        form = new SimilarityResult(this);
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

    public void nextStep() {
        Integer line = form.jTable2.getSelectedRow();
        if (line == -1) {
            JOptionPane.showMessageDialog(form, "Selecione um caso para comparação!", "Erro Inesperado", 0);
            return;
        }
        closeForm();
        CCompareCases.getInstance().createForm();
    }

    public ArrayList<Object> getSelectedValues() {
        Integer line = form.jTable2.getSelectedRow();
        if (line == -1) {
            return null;
        }
        Integer id = (Integer) form.jTable2.getValueAt(line, 0);
        ArrayList<Object> values = RBC.getInstance().findCaseById(id).getCompleteObjectValues();
        return values;
    }
    
    public Double getSimSelected(){
        Integer line = form.jTable2.getSelectedRow();
        if (line == -1) {
            return null;
        }
        return (Double) form.jTable2.getValueAt(line, 2);
    }
}
