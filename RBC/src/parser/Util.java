/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Label;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import rbc.Column;
import rbc.RBC;

/**
 *
 *
 * @author rafael
 */
public class Util {

    public static Number stringNumberConvertion(String n) {
        try {
            return Integer.parseInt(n);
        } catch (NumberFormatException e) {
            try {
                return Double.parseDouble(n);
            } catch (NumberFormatException f) {
                return null;
            }
        }
    }

    public static Integer findInList(ArrayList<Object> list, Object comp) {
        for (Object t : list) {
            if (t.equals(comp)) {
                return list.indexOf(t);
            }
        }
        return null;
    }

    public static Integer DistanceInList(ArrayList<Object> list, Object first, Object last) {
        ArrayList<Object> newList = concatenateList(list);
        Integer posFF = newList.indexOf(first);
        Integer posFL = newList.lastIndexOf(first);
        Integer posLF = newList.indexOf(last);
        Integer distance1 = posFF - posLF;
        Integer distance2 = posFL - posLF;
        if (distance1 < distance2) {
            return distance1;
        }
        return distance2;
    }

    public static ArrayList<Object> concatenateList(ArrayList<Object> list) {
        ArrayList<Object> result = (ArrayList<Object>) list.clone();
        list.forEach((t) -> {
            result.add(t);
        });
        return result;
    }

    public static void readBaseFile(String fileName, Boolean showTree) throws IOException {
        CharStream stream = new ANTLRFileStream(fileName);
        RBC_GrammarLexer lexer = new RBC_GrammarLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        RBC_GrammarParser parser = new RBC_GrammarParser(tokens);
        RBC_GrammarParser.BaseContext base = parser.base();
        BaseVisitor bv = new BaseVisitor();
        bv.visit(base);
        if (showTree) {
            showParseTreeFrame(base, parser);
        }
    }

    public static void showParseTreeFrame(ParseTree tree, RBC_GrammarParser parser) throws HeadlessException {
        JFrame frame = new JFrame("SRC: " + tree.getText());
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewr.setScale(0.75);
        panel.add(viewr);
        frame.add(panel);
        frame.setSize(1000, 600);
        frame.setState(JFrame.MAXIMIZED_HORIZ);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void saveBaseCaseInFile(String fileName) throws IOException {
        try (FileWriter base = new FileWriter(fileName)) {
            base.append(RBC.getInstance().getBaseCase().toString() + '\n');
        }
    }

    public static JTextField createTextField() {
        JTextField t = new JTextField();
        t.setPreferredSize(new Dimension(100, 30));
        return t;
    }

    public static JComboBox createComboBox(Column column) {
        JComboBox j = new JComboBox(column.getPossibleValues().toArray());
        j.addItem("?");
        j.setSelectedIndex(-1);
        return j;
    }

    public static Label createLabel(String text) {
        Label l = new Label(text + ':');
        return l;
    }

    public static ArrayList<Object> extractData(JPanel container) {
        ArrayList<Object> result = new ArrayList<>();
        Arrays.asList(container.getComponents()).forEach((t) -> {
            if (t instanceof JPanel) {
                result.addAll(extractData((JPanel) t));
            } else {
                if (t instanceof JTextField) {
                    Object data = ((JTextField) t).getText();
                    if (data.equals("")) {
                        result.add("?");
                    } else {
                        Number number = stringNumberConvertion(data.toString());
                        if (number == null) {
                            result.add(data);
                        } else {
                            result.add(number);
                        }
                    }
                } else if (t instanceof JComboBox) {
                    Object data = ((JComboBox) t).getSelectedItem();
                    if (data == null) {
                        result.add("?");
                    } else {
                        result.add(data);
                    }
                }
            }
        });
        return result;
    }
}
