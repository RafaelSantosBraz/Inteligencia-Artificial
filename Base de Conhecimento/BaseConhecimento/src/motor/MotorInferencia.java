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

        } else {

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
        Boolean aux = regra.getAntecedentes().get(0).getRelacionamento();
        regra.getAntecedentes().forEach((t) -> {
            if (compararValor(t.getVariavel(), t.getValor(), t.getOperador())) {

            }
        });
        return true;
    }

    private Boolean compararValor(Variavel variavel, Valor valor, Operador operador) {
        if (!variavel.getTipo().getNumerico()) {
            int op = this.ambiente.getOperadores().indexOf(operador);
            switch (op) {
                case 0: // =
                    if (this.ambiente.getMemoTrab(variavel).getTemporarios().contains(valor)) {
                        return true;
                    }
                    return false;
                case 1: // <>
                    if (!this.ambiente.getMemoTrab(variavel).getTemporarios().contains(valor)) {
                        return true;
                    }
                    return false;
            }
        } else {

        }
        return false;
    }

}
