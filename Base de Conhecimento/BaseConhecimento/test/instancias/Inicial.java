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
    }
}
