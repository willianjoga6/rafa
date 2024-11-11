package com.pizzaria.rafa.service;

import com.pizzaria.rafa.Interface.PedidoInterface;
import com.pizzaria.rafa.event.PedidoEvent;
import com.pizzaria.rafa.model.PedidoEntity;
import com.pizzaria.rafa.repository.PedidoRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements PedidoInterface {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoService(ApplicationEventPublisher applicationEventPublisher, PedidoRepository pedidoRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoService() {
    }

    @Override
    public PedidoEntity SavePedido(PedidoEntity pedido){
        PedidoEntity pedidoEntity = pedidoRepository.save(pedido);

        applicationEventPublisher.publishEvent(new PedidoEvent(this, pedidoEntity));

        return pedidoEntity;
    }

    @Override
    public PedidoEntity consultar(long id) {

        return pedidoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Pedido de código %d não encontrado", id)));
    }

    @Override
    public void DeletePedido(Long Id){
        if(!pedidoRepository.existsById(Id)){
            throw new NoResultException(String.format("Pedido de código %d não encontrado", Id));
        }

        pedidoRepository.deleteById(Id);
    }

}
