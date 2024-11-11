package com.pizzaria.rafa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id;
    private String Nome;
    private String Telefone;

    public ClienteEntity() {
    }

    public ClienteEntity(String nome, String telefone) {
        Nome = nome;
        Telefone = telefone;
    }

    public ClienteEntity(long id, String nome, String telefone) {
        Id = id;
        Nome = nome;
        Telefone = telefone;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
