package com.pizzaria.rafa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "CLIENTE_X_ENDERECO")

public class ClienteEnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long IdCliente;
    private String Cep;
    private String Rua;
    private int Numero;
    private String Complemento;

    public ClienteEnderecoEntity() {
    }

    public ClienteEnderecoEntity(long idCliente, String cep, String rua, int numero, String complemento) {
        IdCliente = idCliente;
        Cep = cep;
        Rua = rua;
        Numero = numero;
        Complemento = complemento;
    }

    public ClienteEnderecoEntity(long id, long idCliente, String cep, String rua, int numero, String complemento) {
        Id = id;
        IdCliente = idCliente;
        Cep = cep;
        Rua = rua;
        Numero = numero;
        Complemento = complemento;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(long idCliente) {
        IdCliente = idCliente;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }
}
