package com.pizzaria.rafa.Interface;

import com.pizzaria.rafa.model.PedidoEntity;

import java.util.List;

public interface PedidoInterface {
    PedidoEntity SavePedido(PedidoEntity pedido);
    PedidoEntity consultar(long id);
    void DeletePedido(Long Id);
}
