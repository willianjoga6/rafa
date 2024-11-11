package com.pizzaria.rafa.service;

import com.pizzaria.rafa.Interface.ClienteInterface;
import com.pizzaria.rafa.dto.ClienteDto;
import com.pizzaria.rafa.event.ClienteEvent;
import com.pizzaria.rafa.event.clienteEnderecoEvent;
import com.pizzaria.rafa.model.ClienteEnderecoEntity;
import com.pizzaria.rafa.model.ClienteEntity;
import com.pizzaria.rafa.repository.ClienteEnderecoRepository;
import com.pizzaria.rafa.repository.ClienteRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteInterface {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ClienteEnderecoRepository clienteEnderecoRepository;

    public ClienteService(ApplicationEventPublisher applicationEventPublisher, ClienteRepository clienteRepository, ClienteEnderecoRepository clienteEnderecoRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.clienteRepository = clienteRepository;
        this.clienteEnderecoRepository = clienteEnderecoRepository;
    }

    public ClienteService() {
    }

    @Override
    public ClienteEntity SaveCliente(ClienteEntity cliente){

        ClienteEntity clienteEntity = clienteRepository.save(cliente);

        applicationEventPublisher.publishEvent(new ClienteEvent(this, clienteEntity));

        return clienteEntity;
    }

    @Override
    public ClienteEnderecoEntity SaveClienteEndereco(ClienteEnderecoEntity clienteEndereco){

        ClienteEnderecoEntity clienteEnderecoEntity = clienteEnderecoRepository.save(clienteEndereco);

        applicationEventPublisher.publishEvent(new clienteEnderecoEvent(this, clienteEnderecoEntity));

        return clienteEnderecoEntity;

    }

    @Override
    public ClienteEntity Atualizar (ClienteDto clienteDto, Long Id){
        if(!clienteRepository.existsById(Id)){
            throw new NoResultException(String.format("Cliente de código %d não encontrado", Id));
        }

        ClienteEntity cliente = new ClienteEntity(
                clienteDto.Nome(),
                clienteDto.Telefone()
        );

        var ClienteEnderecoCadastrado = clienteEnderecoRepository.findByIdCliente(Id);
        ClienteEnderecoCadastrado.forEach(f -> {
                    clienteEnderecoRepository.deleteById(f.getId());
                }
        );

        var atualizarCliente = SaveCliente(cliente);

        ClienteEnderecoEntity clienteEnderecoEntity = new ClienteEnderecoEntity(
                atualizarCliente.getId(),
                clienteDto.endereco().CEP().toString(),
                clienteDto.endereco().Rua().toString(),
                clienteDto.endereco().Numero(),
                clienteDto.endereco().Complemento().toString()
        );

        var salvarClienteEndereco = SaveClienteEndereco(clienteEnderecoEntity);

        return atualizarCliente;
    }

    @Override
    public void DeletarPizza(Long Id){
        if(!clienteRepository.existsById(Id)){
            throw new NoResultException(String.format("Cliente de código %d não encontrado", Id));
        }

        var ClienteEndereco = clienteEnderecoRepository.findByIdCliente(Id);
        ClienteEndereco.forEach(f -> {
                    clienteEnderecoRepository.deleteById(f.getId());
                }
        );

        clienteRepository.deleteById(Id);
    }
}
