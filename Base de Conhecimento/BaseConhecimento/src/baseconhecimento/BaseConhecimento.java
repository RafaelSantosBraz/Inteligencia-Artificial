/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconhecimento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Rafael Braz
 */
public class BaseConhecimento {

    private String identificador;
    private List<Regra> regras;
    private List<Variavel> variaveis;

    public BaseConhecimento(String identificador) {
        this.identificador = identificador;
        this.regras = new ArrayList<>();
        this.variaveis = new ArrayList<>();
    }

    public void criarVariavel(String identificador, Tipo tipo) {
        this.variaveis.add(new Variavel(identificador, tipo));
    }

    public void criarVariavel(String identificador, Tipo tipo, Boolean objetivo) {
        this.variaveis.add(new Variavel(identificador, tipo, objetivo));
    }

    public Variavel getVariavel(String identificador) {
        return (Variavel) this.variaveis.stream()
                .filter(x -> x.getIdentificador().equals(identificador))
                .findAny()
                .orElse(null);
    }

    public void criarRegra(String identificador) {
        this.regras.add(new Regra(identificador));
    }

    public Regra getRegra(String identificador) {
        return (Regra) this.regras.stream()
                .filter(x -> x.getIdentificador().equals(identificador))
                .findAny()
                .orElse(null);
    }

    public List<Regra> getRegrasObjetivo(List<Variavel> objetivos) {
        List<Regra> aux = new ArrayList<>();
        this.regras.forEach((t) -> {
            if (!(t.getConsequentes().stream()
                    .filter(x -> objetivos.contains(x.getVariavel()))
                    .collect(Collectors.toList())).isEmpty()) {
                aux.add(t);
            }
        });
        return aux;
    }

    public List<Variavel> getVarObjetivo() {
        return this.variaveis.stream()
                .filter(x -> x.getObjetivo())
                .collect(Collectors.toList());
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public List<Regra> getRegras() {
        return regras;
    }

    public List<Variavel> getVariaveis() {
        return variaveis;
    }

}
