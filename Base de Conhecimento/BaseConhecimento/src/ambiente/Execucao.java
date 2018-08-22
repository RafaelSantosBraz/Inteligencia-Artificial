/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiente;

import baseconhecimento.Regra;

/**
 *
 * @author Rafael Braz
 */
public class Execucao {

    private final int ordem;
    private Boolean resultado;
    private final Regra regra;

    public Execucao(int ordem, Regra regra) {
        this.ordem = ordem;
        this.regra = regra;
    }

    public Regra getRegra() {
        return regra;
    }

    public int getOrdem() {
        return ordem;
    }

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

}
