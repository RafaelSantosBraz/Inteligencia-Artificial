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
public class Antecedente {

    private Variavel variavel;
    private Boolean relacionamento;
    private Valor valor;
    private Boolean not;
    private Operador operador;

    public Antecedente(Variavel variavel, Valor valor, Operador operador) {
        this.variavel = variavel;
        this.valor = valor;
        this.operador = operador;
        this.relacionamento = true;
        this.not = false;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Variavel getVariavel() {
        return variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }

    public Boolean getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(Boolean relacionamento) {
        this.relacionamento = relacionamento;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public Boolean getNot() {
        return not;
    }

    public void setNot(Boolean not) {
        this.not = not;
    }

}
