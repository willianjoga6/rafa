package com.pizzaria.rafa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzaria.rafa.dto.PedidoDto;
import com.pizzaria.rafa.model.PedidoEntity;
import com.pizzaria.rafa.service.PedidoService;
import org.springframework.web.bind.annotation.*;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

@RestController
@RequestMapping("Pedido")

public class PedidoController {

    PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public void CadastrarPedido(@RequestBody PedidoDto pedidoDto){

        pedidoDto.pizza().forEach(f->{

            PedidoEntity pedidoEntity = new PedidoEntity(pedidoDto.IdCliente(), f.IdPizza(), f.Observacao(), pedidoDto.Data());

            var salvarPedido = pedidoService.SavePedido(pedidoEntity);
        });
    }

    @PatchMapping("{id}")
    public PedidoEntity AtualizarPedido(@PathVariable("id") long id, @RequestBody JsonPatch patch) throws JsonProcessingException, JsonPatchException{

        //[
        //    {
        //        "op": "replace",
        //        "path": "/observacao",
        //        "value": "Sem Catupiry"
        //    }
        //]


        PedidoEntity pedidoEntity = pedidoService.consultar(id);

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode pedidoJsonNode = objectMapper.convertValue(pedidoEntity, JsonNode.class);
        JsonNode patchJsonNode = patch.apply(pedidoJsonNode);
        PedidoEntity pedidoPersist = objectMapper.treeToValue(patchJsonNode, PedidoEntity.class);

        return pedidoService.SavePedido(pedidoPersist);
    }


    @DeleteMapping
    public void DeletarPedido(Long Id){

        pedidoService.DeletePedido(Id);
    }
}
