package com.pizzaria.rafa.controller;

import com.pizzaria.rafa.dto.PizzaDto;
import com.pizzaria.rafa.model.PizzaEntity;
import com.pizzaria.rafa.model.PizzaIngredientesEntity;
import com.pizzaria.rafa.service.PizzaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Pizza")

public class PizzaController {

    PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public PizzaEntity CadastrarPizza(@RequestBody PizzaDto pizzaDto){

        PizzaEntity pizza = new PizzaEntity(pizzaDto.Nome(), pizzaDto.tamanhoDto().name(), pizzaDto.Preco());
        var salvarPizza = pizzaService.save(pizza);

        pizzaDto.Ingredientes().forEach( f -> {
            PizzaIngredientesEntity pizzaIngredientesEntity = new PizzaIngredientesEntity(salvarPizza.getId(), f.Ingrediente);
            var salvarPizzaIngredientes = pizzaService.save(pizzaIngredientesEntity);
        });

        return salvarPizza;
    }

    @PutMapping
    public void AtualizarPizza(Long Id, @RequestBody PizzaDto pizzaDto){

        var atualizarPizza = pizzaService.Atualizar(pizzaDto, Id);
    }

    @DeleteMapping
    public void DeletarPizza(Long Id){

        pizzaService.DeletarPizza(Id);
    }
}
