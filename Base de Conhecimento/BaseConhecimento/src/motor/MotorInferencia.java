/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

import ambiente.*;
import baseconhecimento.*;
import com.sun.org.apache.xpath.internal.operations.And;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Rafael Braz
 */
public class MotorInferencia {
    
    private Ambiente ambiente;
    private List<Variavel> objetivos;
    private List<Regra> regrasObjetivo;
    
    public MotorInferencia(Ambiente ambiente) {
        this.ambiente = ambiente;
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
    
    public Boolean executar() {
        // identificar objetivos        
        this.objetivos = ambiente.getBase().getVarObjetivo();
        // regras que tem o objetivo
        this.regrasObjetivo = ambiente.getBase().getRegrasObjetivo(this.objetivos);
        // início da recursão        
        this.regrasObjetivo.forEach((t) -> {
            calcularAntecedentes(t);
        });
        return true;
    }
    
    private void calcularAntecedentes(Regra regra) {
        regra.getAntecedentes().forEach((t) -> {
            List<Regra> aux = listarDefinicoes(t.getVariavel());
            if (aux.isEmpty()) {
                if (this.ambiente.getMemoTrab(t.getVariavel()) == null) {
                    this.ambiente.criarMemoTrab(t.getVariavel());
                }
                this.ambiente.getMemoTrab(t.getVariavel()).addValores(this.ambiente.getInterface(t.getVariavel()).solicitar());
            } else if (this.ambiente.getMemoTrab(t.getVariavel()) == null) {
                aux.forEach((x) -> {
                    calcularAntecedentes(x);
                });
            }
        });
        if (aplicarAntecedentes(regra)) {
            regra.getConsequentes().forEach((t) -> {
                this.ambiente.getMemoTrab(t.getVariavel()).addValor(t.getValor());
            });
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
            // true = And
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
            int comp = Double.compare((double) temps.get(0).getDado(), (double) valor.getDado());
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
    
}
