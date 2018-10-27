/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import parser.Util;
import rbc.Case;
import rbc.Column;
import rbc.RBC;
import rbc.Value;
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
        ArrayList<Value> base = (ArrayList<Value>) RBC.getInstance().getBaseCase().getValues();
        ArrayList<Object> values = CSimilarityResult.getInstance().getSelectedValues();
        String names[] = RBC.getInstance().getColumnNames();
        setTable(names, base, values);
        form.jTextField1.setText(CSimilarityResult.getInstance().getSimSelected().toString());
        form.jPanel3.setLayout(new FlowLayout(1));
        form.jPanel3.doLayout();
        form.jPanel3.repaint();
    }

    private void setTable(String names[], ArrayList<Value> baseValues, ArrayList<Object> selectedValues) {
        form.jTable1.setModel(new DefaultTableModel(new String[]{"Atributos", "Caso Base", "Caso Selecionado"}, names.length + 2));
        form.jTable1.setValueAt("ID", 0, 0);
        form.jTable1.setValueAt(selectedValues.get(0), 0, 2);
        form.jTable1.setValueAt("Objetivo", 1, 0);
        form.jTable1.setValueAt(selectedValues.get(1), 1, 2);
        for (int c = 0; c < names.length; c++) {
            form.jTable1.setValueAt(names[c], c + 2, 0);
            if (baseValues.get(c).getValue() == null) {
                form.jTable1.setValueAt("?", c + 2, 1);
            }
            form.jTable1.setValueAt(baseValues.get(c).getValue(), c + 2, 1);
            if (selectedValues.get(c) == null) {
                form.jTable1.setValueAt("?", c + 2, 2);
            }
            form.jTable1.setValueAt(selectedValues.get(c + 2), c + 2, 2);
        }
        form.jTable1.setEnabled(false);
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
        CSimilarityResult.getInstance().showForm();
    }

    public void nextStep() {
        RBC.getInstance().getBaseCase().setGoal(form.jTable1.getValueAt(1, 2));
        if (Util.saveBaseCaseInFile("base.ia")) {
            JOptionPane.showMessageDialog(form, "Caso retido!", "Ação Efetuada Corretamente", 1);
            form.dispose();
        } else {
            JOptionPane.showMessageDialog(form, "Impossível reter o caso no momento!", "Ação Errada", 0);
        }
    }
}
