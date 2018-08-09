/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiente;

import baseconhecimento.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rafael Braz
 */
public class Ambiente {

    private BaseConhecimento base;
    private List<Interface> interfaces;
    private List<MemoriaTrabalho> memoTrab;
    private List<Tipo> tipos;
    private List<Operador> operadores;
    private List<Execucao> execucoes;

    public Ambiente(String nomeBase) {
        this.base = new BaseConhecimento(nomeBase);
        this.interfaces = new ArrayList<>();
        this.memoTrab = new ArrayList<>();
        this.tipos = new ArrayList<>();
        this.operadores = new ArrayList<>();
        this.execucoes = new ArrayList<>();
        this.tipos.addAll(Arrays.asList(
                new Tipo("numerico", false, true),
                new Tipo("univalorado", false, false),
                new Tipo("multivalorado", true, false)
        ));
        this.operadores.addAll(Arrays.asList(
                new Operador("="),
                new Operador("<>"),
                new Operador(">", false),
                new Operador("<", false),
                new Operador(">=", false),
                new Operador("<=", false)
        ));
    }

    public Tipo getTipo(String identificador) {
        return (Tipo) this.tipos.stream()
                .filter(x -> x.getIdentificador().equals(identificador))
                .findAny()
                .orElse(null);
    }

    public void criarInterface(Variavel variavel) {
        this.interfaces.add(new Interface(variavel));
    }

    public void criarInterface(Variavel variavel, String pergunta) {
        this.interfaces.add(new Interface(variavel, pergunta));
    }

    public void criarInterface(Variavel variavel, String pergunta, String motivo) {
        this.interfaces.add(new Interface(variavel, pergunta, motivo));
    }

    public Interface getInterface(Variavel variavel) {
        return (Interface) this.interfaces.stream()
                .filter(x -> x.getVariavel() == variavel)
                .findAny()
                .orElse(null);
    }

    public Operador getOperador(String identificador) {
        return (Operador) this.operadores.stream()
                .filter(x -> x.getIdentificador().equals(identificador))
                .findAny()
                .orElse(null);
    }

    public void criarMemoTrab(Variavel variavel) {
        this.memoTrab.add(new MemoriaTrabalho(variavel));
    }

    public MemoriaTrabalho getMemoTrab(Variavel variavel) {
        return (MemoriaTrabalho) this.memoTrab.stream()
                .filter(x -> x.getVariavel() == variavel)
                .findAny()
                .orElse(null);
    }

    public BaseConhecimento getBase() {
        return base;
    }

    public List<Interface> getInterfaces() {
        return interfaces;
    }

    public List<MemoriaTrabalho> getMemoTrab() {
        return memoTrab;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public List<Operador> getOperadores() {
        return operadores;
    }

    public List<Execucao> getExecucoes() {
        return execucoes;
    }

}
