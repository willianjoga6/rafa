package com.pizzaria.rafa.event;

import com.pizzaria.rafa.model.PizzaIngredientesEntity;
import org.springframework.context.ApplicationEvent;

public class PizzaIngredientesEvent extends ApplicationEvent {

    private PizzaIngredientesEntity pizzaIngredientesEntity;

    public PizzaIngredientesEvent(Object source, PizzaIngredientesEntity pizzaIngredientesEntity) {
        super(source);
        this.pizzaIngredientesEntity = pizzaIngredientesEntity;
    }

    public PizzaIngredientesEntity getPizzaIngredientesEntity() {
        return pizzaIngredientesEntity;
    }
}
