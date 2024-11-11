package com.pizzaria.rafa.event;

import com.pizzaria.rafa.model.ClienteEnderecoEntity;
import org.springframework.context.ApplicationEvent;

public class clienteEnderecoEvent extends ApplicationEvent {

    ClienteEnderecoEntity clienteEnderecoEntity;

    public clienteEnderecoEvent(Object source, ClienteEnderecoEntity clienteEnderecoEntity) {
        super(source);
        this.clienteEnderecoEntity = clienteEnderecoEntity;
    }

    public ClienteEnderecoEntity getClienteEnderecoEntity() {
        return clienteEnderecoEntity;
    }
}
