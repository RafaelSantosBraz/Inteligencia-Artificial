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
public class BaseConhecimento {

    private String identificador;
    private List<Regra> regras;
    private List<Variavel> variaveis;

    public BaseConhecimento(String identificador) {
        this.identificador = identificador;
        this.regras = new ArrayList<>();
        this.variaveis = new ArrayList<>();
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

    public void setRegras(List<Regra> regras) {
        this.regras = regras;
    }

    public List<Variavel> getVariaveis() {
        return variaveis;
    }

    public void setVariaveis(List<Variavel> variaveis) {
        this.variaveis = variaveis;
    }

}
