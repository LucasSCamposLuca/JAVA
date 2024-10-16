package com.example.projetoFinalJava.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Evento implements Serializable {
        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    @NotEmpty
    private String nome;

    @NotEmpyt
    private String local;

    @NotEmpty
    private String data;

    @NotEmpty
    private String rg;

    @NotEmpty
    private String nomeConvidado;

    @ManyToOne
    private Evento evento;

    public String getRg() {
        return rg;
    }

}
