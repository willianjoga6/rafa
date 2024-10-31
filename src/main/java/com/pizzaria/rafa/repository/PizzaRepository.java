package com.pizzaria.rafa.repository;

import com.pizzaria.rafa.model.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Long> {
}
