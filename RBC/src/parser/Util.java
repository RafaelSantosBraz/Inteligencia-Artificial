/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Action;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
            Number aux = stringNumberConvertion(t.toString());
            if (aux == null) {
                return stringFind(list, comp);
            }
            return numberFind(list, aux);
        }
        return null;
    }

    public static Integer stringFind(ArrayList<Object> list, Object comp) {
        for (Object t : list) {
            if (t.equals(comp)) {
                return list.indexOf(t);
            }
        }
        return null;
    }

    public static Integer numberFind(ArrayList<Object> list, Number comp) {
        for (Object t : list) {
            if (t.equals(comp.toString()));
            {
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

    public static Boolean saveBaseCaseInFile(String fileName) {
        try (FileWriter base = new FileWriter(fileName, true)) {
            base.append(RBC.getInstance().getBaseCase().toString() + '\n');
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static JTextField createTextField() {
        JTextField t = new JTextField();
        t.setPreferredSize(new Dimension(100, 30));
        t.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if ((!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == '.')) || ((e.getKeyChar() == '.') && (t.getText().indexOf('.') != -1))) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        return t;
    }

    public static JComboBox createComboBox(Column column) {
        JComboBox j = new JComboBox(column.getPossibleValues().toArray());
        j.addItem("?");
        j.setSelectedIndex(-1);
        return j;
    }

    public static JLabel createLabel(String text) {
        JLabel l = new JLabel(text + ':');
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
                    if (data.equals("") || data.equals("?")) {
                        result.add(null);
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
                    if (((JComboBox) t).getSelectedIndex() == ((JComboBox) t).getItemCount() - 1) {
                        result.add(null);
                    }
                    result.add(data);
                }
            }
        });
        return result;
    }
}
