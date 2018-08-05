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
public class Variavel {

    private String identificador;
    private Boolean objetivo;
    private List<Valor> valores;
    private Tipo tipo;

    public Variavel(String identificador, Tipo tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.objetivo = false;
        this.valores = new ArrayList<>();
    }

    public Valor getValor(String dado) {
        for (Valor t : this.valores) {
            if (t.getDado().equals(dado)) {
                return t;
            }
        }
        return null;
    }

    public Boolean criarValor(Object dado) {
        if ((this.tipo.getNumerico() && dado instanceof Number) || (!this.tipo.getNumerico())) {
            this.valores.add(new Valor(dado));
            return true;
        }
        return false;
    }

    public List<Valor> getValores() {
        return valores;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Boolean getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Boolean objetivo) {
        this.objetivo = objetivo;
    }

}
