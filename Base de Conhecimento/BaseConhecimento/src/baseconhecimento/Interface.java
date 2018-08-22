/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconhecimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rafael Braz
 */
public class Interface {

    private String pergunta;
    private String motivo;
    private final Variavel variavel;

    public Interface(Variavel variavel) {
        this.variavel = variavel;
    }

    public Interface(Variavel variavel, String pergunta) {
        this.variavel = variavel;
        this.pergunta = pergunta;
    }

    public Interface(Variavel variavel, String pergunta, String motivo) {
        this.pergunta = pergunta;
        this.motivo = motivo;
        this.variavel = variavel;
    }

    public Variavel getVariavel() {
        return variavel;
    }   

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public List<Valor> solicitar() {
        List<Valor> aux = new ArrayList<>();
        System.out.println("Pergunta: " + this.pergunta);
        System.out.println("Motivo: " + this.motivo);
        System.out.println("Valores possíveis: ");
        Scanner s = new Scanner(System.in);        
        if (this.variavel.getTipo().getNumerico()) {
            aux.add(new Valor(s.nextDouble()));
        } else {
            this.variavel.getValores().forEach((t) -> {
                System.out.println("\t" + t.getDado());
            });
            if (this.variavel.getTipo().getMultivalorado()) {
                String val = s.nextLine();
                while (!val.equals("")) {
                    aux.add(this.variavel.getValor(val));
                    val = s.nextLine();
                }
            } else {
                aux.add(this.variavel.getValor(s.next()));
            }
        }
        return aux;
    }
}
