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
    }

    public void criarTipo(String identificador) {
        this.tipos.add(new Tipo(identificador));
    }

    public Tipo getTipo(String identificador) {
        for (Tipo t : this.tipos) {
            if (t.getIdentificador().equals(identificador)) {
                return t;
            }
        }
        return null;
    }

    public void criarInterface(Variavel variavel) {
        this.interfaces.add(new Interface(variavel));
    }

    public Interface getInterface(Variavel variavel) {
        for (Interface t : this.interfaces) {
            if (t.getVariavel() == variavel) {
                return t;
            }
        }
        return null;
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
