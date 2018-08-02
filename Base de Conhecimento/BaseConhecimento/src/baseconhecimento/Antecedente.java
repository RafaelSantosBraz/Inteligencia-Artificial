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
