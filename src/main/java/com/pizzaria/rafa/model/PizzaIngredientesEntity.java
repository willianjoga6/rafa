package com.pizzaria.rafa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "PIZZA_X_INGREDIENTE")
public class PizzaIngredientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long IdPizza;
    private String Descricao;

    public PizzaIngredientesEntity() {
    }

    public PizzaIngredientesEntity(long idPizza, String descricao ) {
        IdPizza = idPizza;
        Descricao = descricao;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getIdPizza() {
        return IdPizza;
    }

    public void setIdPizza(long idPizza) {
        IdPizza = idPizza;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
