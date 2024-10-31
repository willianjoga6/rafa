package com.pizzaria.rafa.dto;

import java.util.List;

public record PizzaDto(String Nome, TamanhoDto tamanhoDto, Float Preco, List<IngredientesDto> Ingredientes) {
}
