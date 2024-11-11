package com.pizzaria.rafa.dto;

import java.util.Date;
import java.util.List;

public record PedidoDto(Long IdCliente, List<PizzaPedidoDto> pizza, Date Data ) {
}
