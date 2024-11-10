package com.pizzaria.rafa.service;

import com.pizzaria.rafa.Interface.PizzaInterface;
import com.pizzaria.rafa.dto.PizzaDto;
import com.pizzaria.rafa.event.PizzaEvent;
import com.pizzaria.rafa.event.PizzaIngredientesEvent;
import com.pizzaria.rafa.model.PizzaEntity;
import com.pizzaria.rafa.model.PizzaIngredientesEntity;
import com.pizzaria.rafa.repository.PizzaIngredientesRepository;
import com.pizzaria.rafa.repository.PizzaRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Service
public class PizzaService implements PizzaInterface {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    PizzaRepository pizzaRepository;
    @Autowired
    PizzaIngredientesRepository pizzaIngredientesRepository;

    public PizzaService(ApplicationEventPublisher applicationEventPublisher, PizzaRepository pizzaRepository, PizzaIngredientesRepository pizzaIngredientesRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.pizzaRepository = pizzaRepository;
        this.pizzaIngredientesRepository = pizzaIngredientesRepository;
    }

    public PizzaService() {
    }

    @Override
    public PizzaEntity save(PizzaEntity pizza) {
        PizzaEntity pizzaEntity = pizzaRepository.save(pizza);

        applicationEventPublisher.publishEvent(new PizzaEvent(this, pizzaEntity));

        return pizzaEntity;
    }

    @Override
    public PizzaIngredientesEntity save(PizzaIngredientesEntity pizzaIngredientes) {
        PizzaIngredientesEntity pizzaIngredientesEntity = pizzaIngredientesRepository.save(pizzaIngredientes);

        applicationEventPublisher.publishEvent(new PizzaIngredientesEvent(this, pizzaIngredientesEntity));

        return pizzaIngredientesEntity;
    }

    @Override
    public PizzaEntity Atualizar (PizzaDto pizzaDto, Long Id){
        if(!pizzaRepository.existsById(Id)){
            throw new NoResultException(String.format("Pizza de código %d não encontrado", Id));
        }

        PizzaEntity pizza = new PizzaEntity(pizzaDto.Nome(), pizzaDto.tamanhoDto().name(), pizzaDto.Preco());

        var PizzaXIngredientesCadastrado = pizzaIngredientesRepository.findByIdPizza(Id);
        PizzaXIngredientesCadastrado.forEach(f -> {
            pizzaIngredientesRepository.deleteById(f.getId());
                }
        );

        var atualizarPizza = save(pizza);

        pizzaDto.Ingredientes().forEach( f -> {
            PizzaIngredientesEntity pizzaIngredientesEntity = new PizzaIngredientesEntity(atualizarPizza.getId(), f.Ingrediente);
            var salvarPizzaIngredientes = save(pizzaIngredientesEntity);
        });

        return atualizarPizza;
    }

    @Override
    public void DeletarPizza(Long Id){
        if(!pizzaRepository.existsById(Id)){
            throw new NoResultException(String.format("Pizza de código %d não encontrado", Id));
        }

        var PizzaXIngredientesCadastrado = pizzaIngredientesRepository.findByIdPizza(Id);
        PizzaXIngredientesCadastrado.forEach(f -> {
                    pizzaIngredientesRepository.deleteById(f.getId());
                }
        );

        pizzaRepository.deleteById(Id);
    }
}
