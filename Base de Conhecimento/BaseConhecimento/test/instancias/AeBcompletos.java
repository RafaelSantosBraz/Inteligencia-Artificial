/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import ambiente.Ambiente;
import baseconhecimento.BaseConhecimento;
import motor.MotorInferencia;

/**
 *
 * @author Rafael Braz
 */
public class AeBcompletos {

    public static void main(String[] args) {
        Ambiente a = new Ambiente("simples");
        BaseConhecimento b = a.getBase();

        b.criarVariavel("A", a.getTipo("univalorado"));
        b.getVariavel("A").criarValor("sim");
        b.getVariavel("A").criarValor("não");

        b.criarVariavel("B", a.getTipo("univalorado"));
        b.getVariavel("B").criarValor("sim");
        b.getVariavel("B").criarValor("não");

        b.criarVariavel("D", a.getTipo("univalorado"), true);
        b.getVariavel("D").criarValor("sim");
        b.getVariavel("D").criarValor("não");

        a.criarInterface(b.getVariavel("A"), "Qual o valor de A?");

        b.criarRegra("R1");
        b.getRegra("R1").criarAntecedente(b.getVariavel("A"), b.getVariavel("A").getValor("sim"), a.getOperador("="));
        b.getRegra("R1").criarConsequente(b.getVariavel("B"), b.getVariavel("B").getValor("sim"));

        b.criarRegra("R3");
        b.getRegra("R3").criarAntecedente(b.getVariavel("A"), b.getVariavel("A").getValor("não"), a.getOperador("="));
        b.getRegra("R3").criarConsequente(b.getVariavel("B"), b.getVariavel("B").getValor("não"));

        b.criarRegra("R2");
        b.getRegra("R2").criarAntecedente(b.getVariavel("B"), b.getVariavel("B").getValor("sim"), a.getOperador("="));
        b.getRegra("R2").criarConsequente(b.getVariavel("D"), b.getVariavel("D").getValor("não"));

        b.criarRegra("R4");
        b.getRegra("R4").criarAntecedente(b.getVariavel("B"), b.getVariavel("B").getValor("não"), a.getOperador("="));
        b.getRegra("R4").criarConsequente(b.getVariavel("D"), b.getVariavel("D").getValor("sim"));

        MotorInferencia m = new MotorInferencia(a);
        m.executar();
    }
}
