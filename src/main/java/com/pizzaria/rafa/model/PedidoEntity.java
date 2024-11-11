package com.pizzaria.rafa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity(name = "Pedido")

public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long Id;
    public long IdCliente;
    public long IdPizza;
    public String Observacao;
    public Date DataPedido;

    public PedidoEntity() {
    }

    public PedidoEntity(long idCliente, long idPizza, String observacao, Date dataPedido) {
        IdCliente = idCliente;
        IdPizza = idPizza;
        Observacao = observacao;
        DataPedido = dataPedido;
    }

    public PedidoEntity(long id, long idCliente, long idPizza, String observacao, Date dataPedido) {
        Id = id;
        IdCliente = idCliente;
        IdPizza = idPizza;
        Observacao = observacao;
        DataPedido = dataPedido;
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

    public long getIdPizza() {
        return IdPizza;
    }

    public void setIdPizza(long idPizza) {
        IdPizza = idPizza;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

    public Date getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        DataPedido = dataPedido;
    }
}
