package com.example.ATVspring.Atividade;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private double preco;

    public Atividade () {}

    public Atividade(String nome, long id, double preco) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
