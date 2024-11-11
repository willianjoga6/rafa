package com.pizzaria.rafa.repository;

import com.pizzaria.rafa.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
