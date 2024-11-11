package com.pizzaria.rafa.event;

import com.pizzaria.rafa.model.PedidoEntity;
import com.pizzaria.rafa.service.PedidoService;
import org.springframework.context.ApplicationEvent;

public class PedidoEvent extends ApplicationEvent {
    PedidoEntity pedidoEntity;

    public PedidoEvent(Object source, PedidoEntity pedidoEntity) {
        super(source);
        this.pedidoEntity = pedidoEntity;
    }

    public PedidoEntity getPedidoEntity() {
        return pedidoEntity;
    }
}
