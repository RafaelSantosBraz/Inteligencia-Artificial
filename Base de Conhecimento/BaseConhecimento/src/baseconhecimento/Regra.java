/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconhecimento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Braz
 */
public class Regra {

    private String identificador;
    private List<Antecedente> antecedentes;
    private List<Consequente> consequentes;

    public Regra(String identificador) {
        this.identificador = identificador;
        this.antecedentes = new ArrayList<>();
        this.consequentes = new ArrayList<>();
    }

    public Boolean criarAntecedente(Variavel variavel, Valor valor, Operador operador) {
        if (variavel.getTipo().getNumerico() && !(valor.getDado() instanceof Number)) {
            return false;
        }
        this.antecedentes.add(new Antecedente(variavel, valor, operador));
        return true;
    }

    public Boolean criarAntecedente(Variavel variavel, Valor valor, Operador operador, Boolean relacionamento) {
        if (variavel.getTipo().getNumerico() && !(valor.getDado() instanceof Number)) {
            return false;
        }
        this.antecedentes.add(new Antecedente(variavel, valor, operador, relacionamento));
        return true;
    }

    public Boolean criarAntecedente(Variavel variavel, Valor valor, Operador operador, Boolean relacionamento, Boolean not) {
        if (variavel.getTipo().getNumerico() && !(valor.getDado() instanceof Number)) {
            return false;
        }
        this.antecedentes.add(new Antecedente(variavel, valor, operador, relacionamento, not));
        return true;
    }

    public Antecedente getAntecedente(Variavel variavel, Valor valor, Operador operador) {
        return (Antecedente) this.antecedentes.stream()
                .filter(x -> (x.getVariavel() == variavel && x.getOperador() == operador && x.getValor() == valor))
                .findAny()
                .orElse(null);
    }

    public void criarConsequente(Variavel variavel, Valor valor) {
        this.consequentes.add(new Consequente(variavel, valor));
    }

    public Consequente getConsequente(Variavel variavel, Valor valor) {
        return (Consequente) this.consequentes.stream()
                .filter(x -> (x.getVariavel() == variavel && x.getValor() == valor))
                .findAny()
                .orElse(null);
    }

    public List<Antecedente> getAntecedentes() {
        return antecedentes;
    }

    public List<Consequente> getConsequentes() {
        return consequentes;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

}
