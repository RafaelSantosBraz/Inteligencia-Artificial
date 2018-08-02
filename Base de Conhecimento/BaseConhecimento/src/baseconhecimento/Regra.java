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
public class Regra {

    private String identificador;
    private List<Antecedente> antecedentes;
    private List<Consequente> consequentes;

    public Regra(String identificador) {
        this.identificador = identificador;
        this.antecedentes = new ArrayList<>();
        this.consequentes = new ArrayList<>();
    }

    public List<Antecedente> getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(List<Antecedente> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public List<Consequente> getConsequentes() {
        return consequentes;
    }

    public void setConsequentes(List<Consequente> consequentes) {
        this.consequentes = consequentes;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

}
