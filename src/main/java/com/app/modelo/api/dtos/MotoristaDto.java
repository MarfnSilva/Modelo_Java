package com.app.modelo.api.dtos;

import com.app.modelo.api.entities.CarroModel;

public class MotoristaDto {

    private String nome;

    private String cpf;

    private String status;

//    private CarroModel carroModel;

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
