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

    private Boolean estado;
    private int ordem;
    private Boolean resultado;
    private Regra regra;

    public Execucao(int ordem, Regra regra) {
        this.ordem = ordem;
        this.regra = regra;
        this.estado = true;
        this.resultado = true;
    }

    public Regra getRegra() {
        return regra;
    }

    public void setRegra(Regra regra) {
        this.regra = regra;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

}
