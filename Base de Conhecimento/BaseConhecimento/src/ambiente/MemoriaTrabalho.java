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

    private final Variavel variavel;
    private final List<Valor> temporarios;

    public MemoriaTrabalho(Variavel variavel) {
        this.variavel = variavel;
        this.temporarios = new ArrayList<>();
    }

    public void addValor(Valor valor) {
        if (this.variavel.getTipo().getNumerico() || !this.variavel.getTipo().getMultivalorado()) {
            if (!this.temporarios.isEmpty()){
                this.temporarios.remove(0);
            }
        } else {
            this.temporarios.add(valor);
        }
    }

    public void addValores(List<Valor> valores) {
        this.temporarios.addAll(valores);
    }

    public Boolean isVazio() {
        return this.temporarios.isEmpty();
    }

    public Variavel getVariavel() {
        return variavel;
    }

    public List<Valor> getTemporarios() {
        return temporarios;
    }

}
