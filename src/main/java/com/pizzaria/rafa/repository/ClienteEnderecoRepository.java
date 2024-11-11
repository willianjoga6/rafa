package com.pizzaria.rafa.repository;

import com.pizzaria.rafa.model.ClienteEnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteEnderecoRepository extends JpaRepository<ClienteEnderecoEntity, Long> {
    @Query("SELECT p FROM CLIENTE_X_ENDERECO p WHERE p.IdCliente = :IdCliente")
    List<ClienteEnderecoEntity> findByIdCliente(@Param("IdCliente") Long IdCliente);
}
