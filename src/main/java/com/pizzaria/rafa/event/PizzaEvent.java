package com.pizzaria.rafa.event;

import com.pizzaria.rafa.model.PizzaEntity;
import org.springframework.context.ApplicationEvent;

public class PizzaEvent extends ApplicationEvent {

    private  PizzaEntity pizzaEntity;

    public PizzaEvent(Object source, PizzaEntity pizzaEntity) {

        super(source);
        this.pizzaEntity = pizzaEntity;
    }

    public PizzaEntity getPizzaEntity() {
        return pizzaEntity;
    }
}
