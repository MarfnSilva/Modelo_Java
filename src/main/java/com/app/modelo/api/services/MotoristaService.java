package com.app.modelo.api.services;

import com.app.modelo.api.entities.MotoristaModel;
import com.app.modelo.api.repository.MotoristaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    MotoristaRepository motoristaRepository;

    @Transactional
    public MotoristaModel save(MotoristaModel motoristaModel){
        return motoristaRepository.save(motoristaModel);
    }

    public boolean existsByNome(String nome){
        return motoristaRepository.existsByNome(nome);
    }

    public boolean existsByCpf(String cpf){
        return motoristaRepository.existsByCpf(cpf);
    }

    public boolean existsByStatus(String status){
        return motoristaRepository.existsByStatus(status);
    }

    public List<MotoristaModel> findAll(){
        return motoristaRepository.findAll();
    }

    public Optional<MotoristaModel> findById(Long id){
        return motoristaRepository.findById(id);
    }

    public void delete(MotoristaModel motoristaModel){
        motoristaRepository.delete(motoristaModel);
    }
}
