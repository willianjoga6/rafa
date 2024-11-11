package com.pizzaria.rafa.event;

import com.pizzaria.rafa.model.ClienteEntity;
import com.pizzaria.rafa.service.ClienteService;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class ClienteEvent extends ApplicationEvent {

    ClienteEntity clienteEntity;

    public ClienteEvent(Object source, ClienteEntity clienteEntity) {
        super(source);
        this.clienteEntity = clienteEntity;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }
}
