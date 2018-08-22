/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import ambiente.Ambiente;
import baseconhecimento.BaseConhecimento;
import baseconhecimento.Valor;
import java.util.Arrays;
import motor.MotorInferencia;

/**
 *
 * @author Rafael Braz
 */
public class Pizza {

    public static void main(String[] args) {
        Ambiente a = new Ambiente("Pizzarriba");
        BaseConhecimento b = a.getBase();

        b.criarVariavel("preco", a.getTipo("numerico"));

        b.criarVariavel("restricao_acucar", a.getTipo("univalorado"));
        b.getVariavel("restricao_acucar").criarValores(
                Arrays.asList("sim", "não")
        );

        b.criarVariavel("restricao_alimentosOrigemAnimal", a.getTipo("univalorado"));
        b.getVariavel("restricao_alimentosOrigemAnimal").criarValores(
                Arrays.asList("sim", "não")
        );

        b.criarVariavel("restricao_carnes", a.getTipo("univalorado"));
        b.getVariavel("restricao_carnes").criarValores(
                Arrays.asList("sim", "não")
        );

        b.criarVariavel("restricao_derivadosLeite", a.getTipo("univalorado"));
        b.getVariavel("restricao_derivadosLeite").criarValores(
                Arrays.asList("sim", "não")
        );

        b.criarVariavel("restricao_salgada", a.getTipo("univalorado"));
        b.getVariavel("restricao_salgada").criarValores(
                Arrays.asList("sim", "não")
        );

        b.criarVariavel("sabor", a.getTipo("multivalorado"), true);
        b.getVariavel("sabor").criarValores(
                Arrays.asList("mussarela", "rucula_tomate_seco", "calabresa_mussarela", "baiana", "calabresa_catupiry", "baiana_catupiry", "pepperoni", "calabresa", "baiana_mussarela", "banana", "banana_crocante", "beijinho", "brigadeiro", "california", "charge", "chocobana", "chocolate", "chocolate_branco", "chokito", "cocada", "confeti", "dois_amores", "prestigio", "sensacao")
        );

        b.criarVariavel("saibo", a.getTipo("multivalorado"));
        b.getVariavel("saibo").criarValores(
                Arrays.asList("doce", "salgada")
        );

        b.criarVariavel("ingredientes_desejados", a.getTipo("multivalorado"));
        b.getVariavel("ingredientes_desejados").criarValores(
                Arrays.asList("calabresa", "mussarela", "cebola", "pimenta", "catupiry", "pepperoni", "leite_condensado", "banana", "acucar", "canela", "chocolate_branco", "coco", "chocolate_po", "chocolate_granulado", "cereja", "figo", "goiaba", "abacaxi", "pessego", "chocolate_preto", "caramelo", "amendoim", "flocos_arroz", "cocoda_cremosa", "confeti", "morango", "rucula", "tomate_seco")
        );

        a.criarInterface(b.getVariavel("ingredientes_desejados"), "Quais os ingredientes desejados?");
        a.criarInterface(b.getVariavel("preco"), "Qual a faixa de preço? 1 a 3.");
//
        b.criarRegra("restricao_derivadosLeite");
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("leite_condensado"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("catupiry"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("caramelo"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_branco"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_granulado"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_preto"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("cocada_cremosa"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("confeti"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("mussarela"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_derivadosLeite").criarConsequente(
                b.getVariavel("restricao_derivadosLeite"),
                b.getVariavel("restricao_derivadosLeite").getValor("sim")
        );
//
        b.criarRegra("restricao_alimentosOrigemAnimal");
        b.getRegra("restricao_alimentosOrigemAnimal").criarAntecedente(
                b.getVariavel("restricao_derivadosLeite"),
                b.getVariavel("restricao_derivadosLeite").getValor("sim"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_alimentosOrigemAnimal").criarAntecedente(
                b.getVariavel("restricao_carnes"),
                b.getVariavel("restricao_carnes").getValor("sim"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_alimentosOrigemAnimal").criarConsequente(
                b.getVariavel("restricao_alimentosOrigemAnimal"),
                b.getVariavel("restricao_alimentosOrigemAnimal").getValor("sim")
        );
//       
        b.criarRegra("restricao_acucar");
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("acucar"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("caramelo"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("cereja"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_branco"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_granulado"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_po"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_preto"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("cocoda_cremosa"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("confeti"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("leite_condesado"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_acucar").criarConsequente(
                b.getVariavel("restricao_acucar"),
                b.getVariavel("restricao_acucar").getValor("não")
        );
//
        b.criarRegra("restricao_salgada");
        b.getRegra("restricao_salgada").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("calabresa"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_salgada").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("catupiry"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_salgada").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("cebola"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_salgada").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("mussarela"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_salgada").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("pepperoni"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_salgada").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("pimenta"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_salgada").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("rucula"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_salgada").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("tomate_seco"),
                a.getOperador("="),
                false
        );
        b.getRegra("restricao_salgada").criarConsequente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não")
        );
//
        b.criarRegra("restricao_doce");
        b.getRegra("restricao_doce").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("sim"),
                a.getOperador("=")
        );
        b.getRegra("restricao_doce").criarAntecedente(
                b.getVariavel("restricao_acucar"),
                b.getVariavel("restricao_acucar").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("restricao_doce").criarConsequente(
                b.getVariavel("saibo"),
                b.getVariavel("saibo").getValor("doce")
        );
//
        b.criarRegra("saibo_salgada");
        b.getRegra("saibo_salgada").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("saibo_salgada").criarAntecedente(
                b.getVariavel("restricao_acucar"),
                b.getVariavel("restricao_acucar").getValor("sim"),
                a.getOperador("=")
        );
        b.getRegra("saibo_salgada").criarConsequente(
                b.getVariavel("saibo"),
                b.getVariavel("saibo").getValor("salgada")
        );
//
        b.criarRegra("mussarela");
        b.getRegra("mussarela").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("mussarela").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(1),
                a.getOperador(">=")
        );
        b.getRegra("mussarela").criarAntecedente(
                b.getVariavel("restricao_derivadosLeite"),
                b.getVariavel("restricao_derivadosLeite").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("mussarela").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("mussarela")
        );
//
        b.criarRegra("rucula");
        b.getRegra("rucula").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("rucula").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(2),
                a.getOperador(">=")
        );
        b.getRegra("rucula").criarAntecedente(
                b.getVariavel("restricao_derivadosLeite"),
                b.getVariavel("restricao_derivadosLeite").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("rucula").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("rucula_tomate_seco")
        );
//
        b.criarRegra("calabresa_mussarela");
        b.getRegra("calabresa_mussarela").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("calabresa_mussarela").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(2),
                a.getOperador(">=")
        );
        b.getRegra("calabresa_mussarela").criarAntecedente(
                b.getVariavel("restricao_alimentosOrigemAnimal"),
                b.getVariavel("restricao_alimentosOrigemAnimal").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("calabresa_mussarela").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("calabresa_mussarela")
        );
//
        b.criarRegra("baiana");
        b.getRegra("baiana").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("baiana").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(2),
                a.getOperador(">=")
        );
        b.getRegra("baiana").criarAntecedente(
                b.getVariavel("restricao_carnes"),
                b.getVariavel("restricao_carnes").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("baiana").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("baiana")
        );
//
        b.criarRegra("calabresa/baiana_catupiry");
        b.getRegra("calabresa/baiana_catupiry").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("calabresa/baiana_catupiry").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(3),
                a.getOperador(">=")
        );
        b.getRegra("calabresa/baiana_catupiry").criarAntecedente(
                b.getVariavel("restricao_alimentosOrigemAnimal"),
                b.getVariavel("restricao_alimentosOrigemAnimal").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("calabresa/baiana_catupiry").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("calabresa_catupiry")
        );
        b.getRegra("calabresa/baiana_catupiry").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("baiana_catupiry")
        );
        b.getRegra("calabresa/baiana_catupiry").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("baiana_mussarela")
        );
//
        b.criarRegra("pepperoni");
        b.getRegra("pepperoni").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("pepperoni").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(2),
                a.getOperador(">=")
        );
        b.getRegra("pepperoni").criarAntecedente(
                b.getVariavel("restricao_alimentosOrigemAnimal"),
                b.getVariavel("restricao_alimentosOrigemAnimal").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("pepperoni").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("pepperoni")
        );
//
        b.criarRegra("calabresa");
        b.getRegra("calabresa").criarAntecedente(
                b.getVariavel("restricao_salgada"),
                b.getVariavel("restricao_salgada").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("calabresa").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(1),
                a.getOperador(">=")
        );
        b.getRegra("calabresa").criarAntecedente(
                b.getVariavel("restricao_alimentosOrigemAnimal"),
                b.getVariavel("restricao_alimentosOrigemAnimal").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("calabresa").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("calabresa")
        );
//
        b.criarRegra("banana");
        b.getRegra("banana").criarAntecedente(
                b.getVariavel("restricao_acucar"),
                b.getVariavel("restricao_acucar").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("banana").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(1),
                a.getOperador(">=")
        );
        b.getRegra("banana").criarAntecedente(
                b.getVariavel("restricao_derivadosLeite"),
                b.getVariavel("restricao_derivadosLeite").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("banana").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("banana")
        );
        b.getRegra("banana").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("chokito")
        );
//
        b.criarRegra("banana_crocante/chocobana/charge/cocada/prestigio");
        b.getRegra("banana_crocante/chocobana/charge/cocada/prestigio").criarAntecedente(
                b.getVariavel("restricao_acucar"),
                b.getVariavel("restricao_acucar").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("banana_crocante/chocobana/charge/cocada/prestigio").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(2),
                a.getOperador(">=")
        );
        b.getRegra("banana_crocante/chocobana/charge/cocada/prestigio").criarAntecedente(
                b.getVariavel("restricao_derivadosLeite"),
                b.getVariavel("restricao_derivadosLeite").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("banana_crocante/chocobana/charge/cocada/prestigio").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("chocobana")
        );
        b.getRegra("banana_crocante/chocobana/charge/cocada/prestigio").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("charge")
        );
        b.getRegra("banana_crocante/chocobana/charge/cocada/prestigio").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("cocada")
        );
        b.getRegra("banana_crocante/chocobana/charge/cocada/prestigio").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("banana_crocante")
        );
        b.getRegra("banana_crocante/chocobana/charge/cocada/prestigio").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("prestigio")
        );
//
        b.criarRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao");
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarAntecedente(
                b.getVariavel("restricao_acucar"),
                b.getVariavel("restricao_acucar").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarAntecedente(
                b.getVariavel("preco"),
                new Valor(3),
                a.getOperador(">=")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarAntecedente(
                b.getVariavel("restricao_derivadosLeite"),
                b.getVariavel("restricao_derivadosLeite").getValor("não"),
                a.getOperador("=")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("beijinho")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("brigadeiro")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("chocolate")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("chocolate_branco")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("confeti")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("dois_amores")
        );
        b.getRegra("beijinho/brigadeiro/chocolate/chocolate_branco/confeti/dois_amores/sensacao").criarConsequente(
                b.getVariavel("sabor"),
                b.getVariavel("sabor").getValor("sensacao")
        );
//
        b.criarRegra("restricao_carnes");
        b.getRegra("restricao_carnes").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("calabresa"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_carnes").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("pepperoni"),
                a.getOperador("="),
                true,
                true
        );
        b.getRegra("restricao_carnes").criarConsequente(
                b.getVariavel("restricao_carnes"),
                b.getVariavel("restricao_carnes").getValor("sim")
        );
//
        b.criarRegra("nao_restricao_carnes");
        b.getRegra("restricao_carnes").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("calabresa"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_carnes").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("pepperoni"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_carnes").criarConsequente(
                b.getVariavel("restricao_carnes"),
                b.getVariavel("restricao_carnes").getValor("não")
        );       
//
        b.criarRegra("nao_restricao_derivadosLeite");
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("leite_condensado"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("catupiry"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("caramelo"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_branco"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_granulado"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("chocolate_preto"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("cocada_cremosa"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("confeti"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarAntecedente(
                b.getVariavel("ingredientes_desejados"),
                b.getVariavel("ingredientes_desejados").getValor("mussarela"),
                a.getOperador("="),
                false
        );
        b.getRegra("nao_restricao_derivadosLeite").criarConsequente(
                b.getVariavel("restricao_derivadosLeite"),
                b.getVariavel("restricao_derivadosLeite").getValor("não")
        );       
        MotorInferencia m = new MotorInferencia(a);
        // m.executar();
    }
}
