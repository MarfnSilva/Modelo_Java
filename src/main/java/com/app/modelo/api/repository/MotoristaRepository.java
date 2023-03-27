package com.app.modelo.api.repository;

import com.app.modelo.api.entities.MotoristaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<MotoristaModel, Long> {

    boolean existsByNome(String nome);

    boolean existsByCpf(String cpf);

    boolean existsByStatus(String status);
}
