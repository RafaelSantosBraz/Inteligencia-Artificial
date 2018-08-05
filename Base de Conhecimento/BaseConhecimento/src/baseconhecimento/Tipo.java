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
public class Tipo {

    private String identificador;
    private Boolean multivalorado;
    private Boolean numerico;

    public Tipo(String identificador, Boolean multivalorado, Boolean numerico) {
        this.identificador = identificador;
        this.multivalorado = multivalorado;
        this.numerico = numerico;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Boolean getMultivalorado() {
        return multivalorado;
    }

    public Boolean getNumerico() {
        return numerico;
    }

}
