/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

import ambiente.*;
import baseconhecimento.*;
import java.util.List;

/**
 *
 * @author Rafael Braz
 */
public class MotorInferencia {

    private Ambiente ambiente;
    private List<Variavel> objetivos;
    private List<Regra> regrasObjetivo;

    public MotorInferencia(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public Boolean executar() {
        // identificar objetivos        
        this.objetivos = ambiente.getBase().getVarObjetivo();
        // regras que tem o objetivo
        this.regrasObjetivo = ambiente.getBase().getRegrasObjetivo(this.objetivos);
        // início da recursão        
        return true;
    }

}
