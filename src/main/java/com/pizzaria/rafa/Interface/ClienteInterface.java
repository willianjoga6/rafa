package com.pizzaria.rafa.Interface;

import com.pizzaria.rafa.dto.ClienteDto;
import com.pizzaria.rafa.model.ClienteEnderecoEntity;
import com.pizzaria.rafa.model.ClienteEntity;

public interface ClienteInterface {
    ClienteEntity SaveCliente(ClienteEntity cliente);
    ClienteEnderecoEntity SaveClienteEndereco(ClienteEnderecoEntity clienteEndereco);
    void DeletarPizza(Long Id);
    ClienteEntity Atualizar (ClienteDto clienteDto, Long Id);
}
