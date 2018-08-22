/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

import ambiente.*;
import baseconhecimento.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 * @author Rafael Braz
 */
public class MotorInferencia {

    private final Ambiente ambiente;
    private List<Variavel> objetivos;
    private List<Regra> regrasObjetivo;
    private Stack<Execucao> execucoes;

    public MotorInferencia(Ambiente ambiente) {
        (this.ambiente = ambiente).getBase().getVariaveis().forEach((t) -> {
            this.ambiente.criarMemoTrab(t);
        });
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public List<Variavel> getObjetivos() {
        return objetivos;
    }

    public List<Regra> getRegrasObjetivo() {
        return regrasObjetivo;
    }

    public Stack<Execucao> getExecucoes() {
        return execucoes;
    }

    public void executar() {
        this.execucoes = new Stack<>();
        // identificar objetivos        
        this.objetivos = ambiente.getBase().getVarObjetivo();
        // regras que tem o objetivo
        this.regrasObjetivo = ambiente.getBase().getRegrasObjetivo(this.objetivos);
        // início da recursão        
        this.regrasObjetivo.forEach((t) -> {
            calcularAntecedentes(t);
        });
        System.out.println("Resultados: ");
        this.objetivos.forEach((t) -> {
            System.out.println("\t Variável: " + t.getIdentificador());
            ambiente.getMemoTrab(t).getTemporarios().forEach((x) -> {
                System.out.println("\t\t" + x.getDado());
            });
        });
    }

    private void calcularAntecedentes(Regra regra) {
        Execucao exe = new Execucao(this.execucoes.isEmpty() ? 1 : this.execucoes.lastElement().getOrdem() + 1, regra);
        this.execucoes.push(exe);
        regra.getAntecedentes().forEach((t) -> {
            List<Regra> aux = listarDefinicoes(t.getVariavel());
            MemoriaTrabalho memo = this.ambiente.getMemoTrab(t.getVariavel());
            if (aux.isEmpty() && memo.isVazio()) {
                memo.addValores(this.ambiente.getInterface(t.getVariavel()).solicitar());
            } else if (!aux.isEmpty()) {
                aux.forEach((x) -> {
                    calcularAntecedentes(x);
                });
            }
        });
        if (aplicarAntecedentes(regra)) {
            this.execucoes.get(this.execucoes.indexOf(exe)).setResultado(true);
            regra.getConsequentes().forEach((t) -> {
                this.ambiente.getMemoTrab(t.getVariavel()).addValor(t.getValor());
            });
        } else {
            this.execucoes.get(this.execucoes.indexOf(exe)).setResultado(true);
        }
    }

    private List<Regra> listarDefinicoes(Variavel variavel) {
        List<Regra> aux = new ArrayList<>();
        this.ambiente.getBase().getRegras().forEach((t) -> {
            if (!(t.getConsequentes().stream()
                    .filter(x -> x.getVariavel() == variavel)
                    .collect(Collectors.toList())).isEmpty()) {
                aux.add(t);
            }
        });
        return aux;
    }

    private Boolean aplicarAntecedentes(Regra regra) {
        Boolean resp = regra.getAntecedentes().get(0).getRelacionamento();
        for (Antecedente t : regra.getAntecedentes()) {
            // true = and
            if (t.getRelacionamento()) {
                resp = Boolean.logicalAnd(resp, compararValor(t.getVariavel(), t.getValor(), t.getOperador(), t.getNot()));
            } else {
                resp = Boolean.logicalOr(resp, compararValor(t.getVariavel(), t.getValor(), t.getOperador(), t.getNot()));
            }
        }
        return resp;
    }

    private Boolean compararValor(Variavel variavel, Valor valor, Operador operador, Boolean not) {
        Boolean aux = false;
        int op = this.ambiente.getOperadores().indexOf(operador);
        List<Valor> temps = this.ambiente.getMemoTrab(variavel).getTemporarios();
        if (!variavel.getTipo().getNumerico()) {
            // = <>
            if ((op == 0 && temps.contains(valor)) || (op == 1 && !temps.contains(valor))) {
                aux = true;
            }
        } else {
            // 0 - igual, >0 - maior, <0 - menor
            int comp = Double.compare(Double.parseDouble(temps.get(0).getDado().toString()), Double.parseDouble(valor.getDado().toString()));
            // = <> > < >= <=
            if ((op == 0 && comp == 0)
                    || (op == 1 && comp != 0)
                    || (op == 2 && comp > 0)
                    || (op == 3 && comp < 0)
                    || (op == 4 && comp >= 0)
                    || (op == 5 && comp <= 0)) {
                aux = true;
            }
        }
        if (not) {
            aux = !aux;
        }
        return aux;
    }

    public void imprimirPilha() {
        System.out.println("Execuções:\n");
        while (!this.execucoes.empty()) {
            Execucao a = this.execucoes.pop();
            System.out.println(a.getRegra().getIdentificador());
            System.out.println(a.getOrdem());
            System.out.println(a.getResultado() + "\n");
        }
    }
}
