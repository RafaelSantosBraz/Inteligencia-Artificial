/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import baseconhecimento.*;

/**
 *
 * @author Rafael Braz
 */
public class Inicial {

    public static void main(String[] args) {
        Ambiente teste = new Ambiente("inicial");
        teste.criarTipo("numerico");
        teste.criarTipo("univalorado");
        teste.getBase().criarVariavel("custo", teste.getTipo("numerico"));
        teste.getBase().criarVariavel("comprar", teste.getTipo("univalorado"));
        teste.getBase().getVariavel("comprar").criarValor("sim");
        teste.getBase().getVariavel("comprar").criarValor("nao");
        teste.getBase().getVariavel("comprar").setObjetivo(true);
        teste.getBase().criarVariavel("avaliacao", teste.getTipo("univalorado"));
        teste.getBase().getVariavel("avaliacao").criarValor("caro");
        teste.getBase().getVariavel("avaliacao").criarValor("barato");
        teste.criarInterface(teste.getBase().getVariavel("custo"));
        teste.getInterface(teste.getBase().getVariavel("custo")).setPergunta("Qual o valor?");
        teste.getInterface(teste.getBase().getVariavel("custo")).setMotivo("Saber o valor.");
        teste.criarOperador(">=");
        teste.criarOperador("=");
        teste.criarOperador("<");
        teste.getBase().criarRegra("avaliar_caro");
        teste.getBase().getRegra("avaliar_caro").criarAntecedente(teste.getBase().getVariavel("custo"), new Valor("1000"), teste.getOperador(">="));
        teste.getBase().getRegra("avaliar_caro").criarConsequente(teste.getBase().getVariavel("avaliacao"), teste.getBase().getVariavel("avaliacao").getValor("caro"));
        teste.getBase().criarRegra("avaliar_barato");
        teste.getBase().getRegra("avaliar_barato").criarAntecedente(teste.getBase().getVariavel("custo"), new Valor("1000"), teste.getOperador("<"));
        teste.getBase().getRegra("avaliar_barato").criarConsequente(teste.getBase().getVariavel("avaliacao"), teste.getBase().getVariavel("avaliacao").getValor("barato"));
        teste.getBase().criarRegra("aprovar_compra");
        teste.getBase().getRegra("aprovar_compra").criarAntecedente(teste.getBase().getVariavel("avaliacao"), teste.getBase().getVariavel("avaliacao").getValor("caro"), teste.getOperador("="));
        teste.getBase().getRegra("aprovar_compra").criarConsequente(teste.getBase().getVariavel("comprar"), teste.getBase().getVariavel("comprar").getValor("nao"));
        teste.getBase().criarRegra("reprovar_compra");
        teste.getBase().getRegra("reprovar_compra").criarAntecedente(teste.getBase().getVariavel("avaliacao"), teste.getBase().getVariavel("avaliacao").getValor("barato"), teste.getOperador("="));
        teste.getBase().getRegra("reprovar_compra").criarConsequente(teste.getBase().getVariavel("comprar"), teste.getBase().getVariavel("comprar").getValor("sim"));
    }
}
