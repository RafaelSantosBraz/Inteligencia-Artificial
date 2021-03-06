/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import parser.Util;
import rbc.Case;
import rbc.RBC;
import rbc.Value;
import view.DataCollector;

/**
 *
 * @author rafael
 */
public class CDataCollector {

    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static CDataCollector instance;

    public static CDataCollector getInstance() {
        if (instance == null) {
            instance = new CDataCollector();
        }
        return instance;
    }
    //</editor-fold>

    private DataCollector form;

    public CDataCollector() {
        form = new DataCollector(this);
    }

    private void setCollumsData() {
        RBC.getInstance().getColumns().forEach((t) -> {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(form.jPanel4.getWidth() - 100, 50));
            form.jPanel4.add(panel);
            panel.add(Util.createLabel(t.getName()));
            if (t.getMathType() == 0) {
                panel.add(Util.createTextField());
            } else {
                panel.add(Util.createComboBox(t));
            }
            panel.setLayout(new GridLayout(2, 2));
            panel.doLayout();
            panel.repaint();
        });
        form.jPanel4.setPreferredSize(new Dimension(800, RBC.getInstance().getColumns().size() * 65));
        form.jPanel4.setLayout(new FlowLayout(1));
        form.jPanel4.doLayout();
        form.jPanel4.repaint();        
        form.jPanel3.setLayout(new FlowLayout(1));
        form.jPanel3.doLayout();
        form.jPanel3.repaint();
    }

    public void createForm() {
        setCollumsData();
        form.setVisible(true);
    }

    public void renewForm() {
        form.dispose();
        form = new DataCollector(this);
        setCollumsData();
        form.setVisible(true);
    }

    public void showForm() {
        form.setVisible(true);
    }

    public void closeForm() {
        form.setVisible(false);
    }

    public void createBaseCase() {
        ArrayList<Object> data = Util.extractData(form.jPanel4);
        ArrayList<Value> values = new ArrayList<>();
        RBC.getInstance().setBaseCase(new Case(RBC.getInstance().getCases().get(RBC.getInstance().getCases().size() - 1).getId() + 1, null));
        data.forEach((t) -> {
            values.add(new Value(RBC.getInstance().getColumns().get(data.indexOf(t)), t));
        });
        RBC.getInstance().getBaseCase().addValues(values);
    }

    public void nextStep(String textCnf) {
        Number cnf = Util.stringNumberConvertion(textCnf);
        if (cnf == null) {
            cnf = 0.0;
        } else {
            cnf = cnf.doubleValue() / 100.0;
        }
        form.setVisible(false);
        RBC.getInstance().setCnf(cnf.doubleValue());
        CSimilarityResult.getInstance().createForm();
    }

    public void finishForm() {
        form.dispose();
    }
}
