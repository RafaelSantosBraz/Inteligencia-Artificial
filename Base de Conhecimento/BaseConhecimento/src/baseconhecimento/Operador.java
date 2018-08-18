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
public class Operador {

    private String identificador;
    private Boolean geral;

    public Operador(String identificador) {
        this.identificador = identificador;
        this.geral = true;
    }
    
    public Operador(String identificador, Boolean geral) {
        this.identificador = identificador;
        this.geral = geral;
    }
    
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Boolean getGeral() {
        return geral;
    }

    public void setGeral(Boolean geral) {
        this.geral = geral;
    }

}
