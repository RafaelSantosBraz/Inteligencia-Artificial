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
 * @author a120121
 */
public class MotorInferencia {

    private Ambiente ambiente;

    public MotorInferencia(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public Boolean executar() {
        // identificar objetivos        
        List<Variavel> objetivos = ambiente.getBase().getVarObjetivo();
        // regras que tem o objetivo
        List<Regra> regrasObjetivo;
        // início da recursão
        return true;
    }

}
