/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import parser.Util;
import rbc.Column;
import rbc.RBC;
import view.DataCollector;

/**
 *
 * @author rafael
 */
public class CDataCollector {

    private final DataCollector form;

    public CDataCollector() {
        form = new DataCollector();
        setCollumsData();
        form.setVisible(true);
    }

    private void setCollumsData() {
        RBC.getInstance().getColumns().forEach((t) -> {
            JPanel panel = new JPanel();  
            panel.setPreferredSize(new Dimension(form.getWidth()-100, 50));
            form.jPanel1.add(panel);
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
        form.jPanel1.setLayout(new FlowLayout(1));
        form.jPanel1.doLayout();
        form.jPanel1.repaint();
    }   
}
