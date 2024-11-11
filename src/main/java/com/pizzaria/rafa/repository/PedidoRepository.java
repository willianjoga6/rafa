package com.pizzaria.rafa.repository;

import com.pizzaria.rafa.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
