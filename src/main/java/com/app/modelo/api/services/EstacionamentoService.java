package com.app.modelo.api.services;

import com.app.modelo.api.entities.CarroModel;
import com.app.modelo.api.entities.EstacionamentoModel;
import com.app.modelo.api.repository.EstacionamentoRepository;
import jakarta.transaction.Transactional;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {
    @Autowired
    EstacionamentoRepository estacionamentoRepository;
    @Transactional
    public EstacionamentoModel save(EstacionamentoModel estacionamentoModel){
        return estacionamentoRepository.save(estacionamentoModel);
    }

    public boolean existsByDataInicial(LocalDateTime dataInicial){
        return estacionamentoRepository.existsByDataInicial(dataInicial);
    }

    public boolean existsByDataFinal(LocalDateTime dataFinal){
        return estacionamentoRepository.existsByDataFinal(dataFinal);
    }

    public boolean existsByPreco(String preco){
        return estacionamentoRepository.existsByPreco(preco);
    }

    public boolean existsByStatus(String status){
        return estacionamentoRepository.existsByStatus(status);
    }

    public List<EstacionamentoModel> findall(){
        return estacionamentoRepository.findAll();
    }

    public Optional<EstacionamentoModel> findById(Long id){
        return estacionamentoRepository.findById(id);
    }

    public void delete(EstacionamentoModel estacionamentoModel){
        estacionamentoRepository.delete(estacionamentoModel);
    }
}
