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

    public void criarAntecedente(Variavel variavel, Valor valor, Operador operador) {
        this.antecedentes.add(new Antecedente(variavel, valor, operador));
    }

    public Antecedente getAntecedente(Variavel variavel, Valor valor, Operador operador) {
        for (Antecedente c : this.antecedentes) {
            if (c.getVariavel() == variavel && c.getOperador() == operador && c.getValor() == valor) {
                return c;
            }
        }
        return null;
    }

    public void criarConsequente(Variavel variavel, Valor valor) {
        this.consequentes.add(new Consequente(variavel, valor));
    }

    public Consequente getConsequente(Variavel variavel, Valor valor) {
        for (Consequente c : this.consequentes) {
            if (c.getVariavel() == variavel && c.getValor() == valor) {
                return c;
            }
        }
        return null;
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
