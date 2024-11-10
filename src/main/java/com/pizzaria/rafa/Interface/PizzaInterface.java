package com.pizzaria.rafa.Interface;

import com.pizzaria.rafa.dto.PizzaDto;
import com.pizzaria.rafa.model.PizzaEntity;
import com.pizzaria.rafa.model.PizzaIngredientesEntity;

public interface PizzaInterface {
    PizzaEntity save(PizzaEntity pizzaEntity);
    PizzaIngredientesEntity save(PizzaIngredientesEntity pizzaIngredientes);
    PizzaEntity Atualizar (PizzaDto pizzaDto, Long Id);
    void DeletarPizza(Long Id);
}
