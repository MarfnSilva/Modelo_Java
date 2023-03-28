package com.app.modelo.api.dtos;

import com.app.modelo.api.entities.CarroModel;
import com.app.modelo.api.enums.StatusMotorista;

public class MotoristaDto {

    private String nome;

    private String cpf;

    private StatusMotorista status;


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

    public StatusMotorista getStatus() {
        return status;
    }

    public void setStatus(StatusMotorista status) {
        this.status = status;
    }
}
