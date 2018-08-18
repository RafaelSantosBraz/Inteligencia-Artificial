/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import ambiente.Ambiente;
import baseconhecimento.BaseConhecimento;
import baseconhecimento.Valor;
import baseconhecimento.Variavel;
import java.util.List;

/**
 *
 * @author a120121
 */
public class Filtros {

    public static void main(String[] args) {
        Ambiente teste = new Ambiente("inicial");
        BaseConhecimento base = teste.getBase();
        base.criarVariavel("custo", teste.getTipo("numerico"));
        base.criarVariavel("comprar", teste.getTipo("univalorado"));
        base.getVariavel("comprar").criarValor("sim");
        base.getVariavel("comprar").criarValor("nao");
        base.getVariavel("comprar").setObjetivo(true);
        base.criarVariavel("avaliacao", teste.getTipo("univalorado"));
        base.getVariavel("avaliacao").criarValor("caro");
        base.getVariavel("avaliacao").criarValor("barato");
        teste.criarInterface(base.getVariavel("custo"));
        teste.getInterface(base.getVariavel("custo")).setPergunta("Qual o valor?");
        teste.getInterface(base.getVariavel("custo")).setMotivo("Saber o valor.");
        base.criarRegra("avaliar_caro");
        base.getRegra("avaliar_caro").criarAntecedente(base.getVariavel("custo"), new Valor(1000), teste.getOperador(">="));
        base.getRegra("avaliar_caro").criarConsequente(base.getVariavel("avaliacao"), base.getVariavel("avaliacao").getValor("caro"));
        base.criarRegra("avaliar_barato");
        base.getRegra("avaliar_barato").criarAntecedente(base.getVariavel("custo"), new Valor(1000), teste.getOperador("<"));
        base.getRegra("avaliar_barato").criarConsequente(base.getVariavel("avaliacao"), base.getVariavel("avaliacao").getValor("barato"));
        base.criarRegra("aprovar_compra");
        base.getRegra("aprovar_compra").criarAntecedente(base.getVariavel("avaliacao"), base.getVariavel("avaliacao").getValor("caro"), teste.getOperador("="));
        base.getRegra("aprovar_compra").criarConsequente(base.getVariavel("comprar"), base.getVariavel("comprar").getValor("nao"));
        base.criarRegra("reprovar_compra");
        base.getRegra("reprovar_compra").criarAntecedente(base.getVariavel("avaliacao"), base.getVariavel("avaliacao").getValor("barato"), teste.getOperador("="));
        base.getRegra("reprovar_compra").criarConsequente(base.getVariavel("comprar"), base.getVariavel("comprar").getValor("sim"));
        
        
        
        List<Variavel> aux = base.getVarObjetivo();
    }
}
