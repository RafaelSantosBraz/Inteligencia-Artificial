/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconhecimento;

/**
 *
 * @author Rafael Braz
 */
public class Consequente {

    private Variavel variavel;
    private Valor valor;

    public Consequente(Variavel variavel, Valor valor) {
        this.variavel = variavel;
        this.valor = valor;
    }

    public Variavel getVariavel() {
        return variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

}
