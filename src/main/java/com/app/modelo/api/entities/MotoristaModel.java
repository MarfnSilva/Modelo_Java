package com.app.modelo.api.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonTypeId;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.io.Serial;
import java.io.Serializable;
@Entity
@Table(name = "motorista")
public class MotoristaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String status;

//    @ManyToOne
//    @JoinColumn(name = "carro_id")
//    private CarroModel carroModel;

    public MotoristaModel(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public CarroModel getCarroModel() {
//        return carroModel;
//    }
//
//    public void setCarroModel(CarroModel carroModel) {
//        this.carroModel = carroModel;
//    }
}
