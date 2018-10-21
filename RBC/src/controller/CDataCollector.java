/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
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
        ArrayList<Column> columns = (ArrayList<Column>) RBC.getInstance().getColumns();
        form.jTable1.setModel(getTableModel());
        String names[] = RBC.getInstance().getColumnNames();
        for (int c = 0; c < columns.size(); c++) {
            form.jTable1.setValueAt(names[c], c, 0);
        }
        for (int c = 0; c < columns.size(); c++) {
            Object editor = Util.defineTableObject(columns.get(c));
            if (editor != null) {
                form.jTable1.setCellEditor(new DefaultCellEditor((JComboBox) editor));
            }
        }
    }

    private TableModel getTableModel() {
        String names[] = {"Atributos", "Valores"};
        return new DefaultTableModel(names, RBC.getInstance().getColumns().size());
    }
}
