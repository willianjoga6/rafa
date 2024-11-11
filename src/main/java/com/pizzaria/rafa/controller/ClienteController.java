package com.pizzaria.rafa.controller;

import com.pizzaria.rafa.dto.ClienteDto;
import com.pizzaria.rafa.dto.PizzaDto;
import com.pizzaria.rafa.model.ClienteEnderecoEntity;
import com.pizzaria.rafa.model.ClienteEntity;
import com.pizzaria.rafa.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Clientes")

public class ClienteController {

    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteEntity CadastrarCliente(@RequestBody ClienteDto cliente){

        ClienteEntity clienteEntity = new ClienteEntity(
                cliente.Nome(),
                cliente.Telefone()
        );
        var inserirCliente = clienteService.SaveCliente(clienteEntity);

        ClienteEnderecoEntity clienteEnderecoEntity = new ClienteEnderecoEntity(
                inserirCliente.getId(),
                cliente.endereco().CEP().toString(),
                cliente.endereco().Rua().toString(),
                cliente.endereco().Numero(),
                cliente.endereco().Complemento().toString()
        );

        var inserirClienteEndereco = clienteService.SaveClienteEndereco(clienteEnderecoEntity);

        return inserirCliente;
    }

    @PutMapping
    public void AtualizarCliente(Long Id, @RequestBody ClienteDto clienteDto){

        var atualizarPizza = clienteService.Atualizar(clienteDto, Id);
    }

    @DeleteMapping
    public void DeletarCliente(Long Id){
        clienteService.DeletarPizza(Id);
    }
}
