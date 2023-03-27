package com.app.modelo.api.repository;

import com.app.modelo.api.entities.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroModel, Long> {

    boolean existsByMarca(String marca);

    boolean existsByModelo(String modelo);

    boolean existsByPlaca(String placa);

    boolean existsByStatus(String status);
}
