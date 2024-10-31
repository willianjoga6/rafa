package com.pizzaria.rafa.repository;

import com.pizzaria.rafa.model.PizzaIngredientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaIngredientesRepository extends JpaRepository<PizzaIngredientesEntity, Long> {

    @Query("SELECT p FROM PIZZA_X_INGREDIENTE p WHERE p.IdPizza = :idPizza")
    List<PizzaIngredientesEntity> findByIdPizza(@Param("idPizza") Long idPizza);
}
