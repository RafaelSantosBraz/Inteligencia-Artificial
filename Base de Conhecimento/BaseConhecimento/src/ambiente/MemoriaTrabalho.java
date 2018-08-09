/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiente;

import baseconhecimento.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Braz
 */
public class MemoriaTrabalho {

    private Variavel variavel;
    private List<Valor> temporarios;

    public MemoriaTrabalho(Variavel variavel) {
        this.variavel = variavel;
        this.temporarios = new ArrayList<>();
    }

    public void addValor(Valor valor) {
        this.temporarios.add(valor);
    }

    public void addValores(List<Valor> valores) {
        this.temporarios.addAll(valores);
    }

    public Variavel getVariavel() {
        return variavel;
    }

    public void setVariavel(Variavel variavel) {
        this.variavel = variavel;
    }

    public List<Valor> getTemporarios() {
        return temporarios;
    }

}
