/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbc;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;

/**
 *
 * @author rafael
 */
public class Run {

    public static void main(String[] args) throws IOException {
        String filename = "base.ia";
        if (args.length >= 1) {
            filename = args[0];
        }
        CharStream stream = null;
        if (filename != null) {
            stream = new ANTLRFileStream(filename);
        } else {
            stream = new ANTLRInputStream(System.in);
        }
        RBC_GrammarLexer lexer = new RBC_GrammarLexer(stream);            //Lexer
        TokenStream tokens = new CommonTokenStream(lexer);  //nextToken 
        RBC_GrammarParser parser = new RBC_GrammarParser(tokens);         //Parser
        RBC_GrammarParser.BaseContext base
                = parser.base();        //Exec Parser prog
        BaseVisitor bv = new BaseVisitor();
        bv.visit(base);
        RBC test = RBC.getInstance();
        showParseTreeFrame(base, parser);
        //System.out.println(SymbolTable.getInstance().dumpTable());
        //MyProgVisitor pv = new MyProgVisitor();
        //pv.visit(prog);
    }

    private static void showParseTreeFrame(ParseTree tree, RBC_GrammarParser parser) throws HeadlessException {
        JFrame frame = new JFrame("SRC: " + tree.getText());
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()), tree);
        viewr.setScale(0.75);
        panel.add(viewr);
        frame.add(panel);
        frame.setSize(1000, 600);
        frame.setState(JFrame.MAXIMIZED_HORIZ);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
