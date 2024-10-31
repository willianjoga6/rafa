package com.pizzaria.rafa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "pizza")

public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Nome;
    private String Tamanho;
    private Float Preco;

    public PizzaEntity(String nome, String tamanho, Float preco) {
        Nome = nome;
        Tamanho = tamanho;
        Preco = preco;
    }

    public PizzaEntity(long id, String nome, String tamanho, Float preco) {
        Id = id;
        Nome = nome;
        Tamanho = tamanho;
        Preco = preco;
    }

    public long getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }
    public String getTamanho() {
        return Tamanho;
    }

    public Float getPreco() {
        return Preco;
    }
}
