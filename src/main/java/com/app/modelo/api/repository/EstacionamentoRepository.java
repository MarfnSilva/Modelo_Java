package com.app.modelo.api.repository;

import com.app.modelo.api.entities.EstacionamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Repository
public interface EstacionamentoRepository  extends JpaRepository<EstacionamentoModel, Long> {

    boolean existsByDataInicial(LocalDateTime dataInicial);

    boolean existsByDataFinal(LocalDateTime dataFinal);

    boolean existsByPreco(String preco);

    boolean existsByStatus(String status);
}
