package com.example.projetoFinalJava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Convidado {

    @Id
    @NotEmpty
    private String rg;

    @NotEmpty
    private String nomeConvidado;

    @ManyToOne
    private Evento evento;

    public String getRg(){return rg;}
    public void setRg(String rg) {this.rg = rg;}
    public String getNomeConvidado(){return  nomeConvidado;}

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }
}
