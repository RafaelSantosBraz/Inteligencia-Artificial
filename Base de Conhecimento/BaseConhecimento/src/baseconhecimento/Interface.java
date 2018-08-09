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
public class Interface {

    private String pergunta;
    private String motivo;
    private Variavel variavel;

    public Interface(Variavel variavel) {
        this.variavel = variavel;
    }

    public Interface(Variavel variavel, String pergunta) {
        this.variavel = variavel;
        this.pergunta = pergunta;
    }

    public Interface(Variavel variavel, String pergunta, String motivo) {
        this.pergunta = pergunta;
        this.motivo = motivo;
        this.variavel = variavel;
    }

    public Variavel getVariavel() {
        return variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
