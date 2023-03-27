package com.app.modelo.api.services;

import com.app.modelo.api.entities.CarroModel;
import com.app.modelo.api.repository.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    CarroRepository carroRepository;

    @Transactional
    public CarroModel save(CarroModel carroModel){
        return carroRepository.save(carroModel);
    }

    public boolean existsByMarca(String marca){
        return carroRepository.existsByMarca(marca);
    }

    public boolean existsByModelo(String modelo){
        return carroRepository.existsByModelo(modelo);
    }

    public boolean existsByPlaca(String placa){
        return carroRepository.existsByPlaca(placa);
    }


    public boolean existsByStatus(String status){
        return carroRepository.existsByStatus(status);
    }

    public List<CarroModel> findAll(){
        return carroRepository.findAll();
    }

    public Optional<CarroModel> findById(Long id){
        return carroRepository.findById(id);
    }

    public void delete(CarroModel carroModel){
        carroRepository.delete(carroModel);
    }
}
