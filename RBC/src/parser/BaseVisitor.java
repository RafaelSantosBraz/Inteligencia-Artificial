/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import rbc.*;

/**
 *
 * @author rafael
 */
public class BaseVisitor extends RBC_GrammarBaseVisitor<Object> {

    @Override
    public Object visitHead(RBC_GrammarParser.HeadContext ctx) {
        ArrayList<Integer> types = (ArrayList<Integer>) visit(ctx.types());
        ArrayList<Integer> weights = (ArrayList<Integer>) visit(ctx.weights());
        ArrayList<String> names = (ArrayList<String>) visit(ctx.ident());
        for (int i = 0; i < types.size(); i++) {
            RBC.getInstance().addColumn(new Column(names.get(i), types.get(i), weights.get(i)));
        }
        ctx.stand().forEach((t) -> {
            visit(t);
        });
        return null;
    }

    @Override
    public Object visitTypes(RBC_GrammarParser.TypesContext ctx) {
        ArrayList<Integer> types = new ArrayList<>();
        ctx.NUM().forEach((t) -> {
            types.add(Integer.parseInt(t.getText()));
        });
        return types;
    }

    @Override
    public Object visitWeights(RBC_GrammarParser.WeightsContext ctx) {
        ArrayList<Integer> weights = new ArrayList<>();
        ctx.NUM().forEach((t) -> {
            weights.add(Integer.parseInt(t.getText()));
        });
        return weights;
    }

    @Override
    public Object visitIdent(RBC_GrammarParser.IdentContext ctx) {
        ArrayList<String> names = new ArrayList<>();
        ctx.STR().forEach((t) -> {
            names.add(t.getText());
        });
        return names;
    }

    @Override
    public Object visitValues(RBC_GrammarParser.ValuesContext ctx) {
        Case ccase = new Case(Integer.parseInt(ctx.NUM().getText()), visit(ctx.goal()));
        RBC.getInstance().addCase(ccase);
        for (int i = 0; i < ctx.value().size(); i++) {
            ccase.addValue(new Value(RBC.getInstance().getColumns().get(i), visit(ctx.value(i))));
        }
        return null;
    }

    @Override
    public Object visitValueStr(RBC_GrammarParser.ValueStrContext ctx) {
        if (ctx.STR().getText().equals("?")) {
            return null;
        }
        return ctx.STR().getText();
    }

    @Override
    public Object visitValueNum(RBC_GrammarParser.ValueNumContext ctx) {
        return Util.stringNumberConvertion(ctx.NUM().getText());
    }

    @Override
    public Object visitStand(RBC_GrammarParser.StandContext ctx) {
        RBC.getInstance().getColumns().forEach((t) -> {
            if (t.getName().equals(ctx.STR().getText())) {
                ctx.value().forEach((x) -> {
                    t.addPossibleValue(visit(x));
                });
            }
        });
        return null;
    }

}
