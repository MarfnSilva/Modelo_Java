package com.app.modelo.api.dtos;

import com.app.modelo.api.entities.MotoristaModel;
import com.app.modelo.api.enums.StatusCarro;

public class CarroDto {

    private String marca;

    private String modelo;

    private String placa;

    private StatusCarro status;

    private MotoristaModel motorista;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public StatusCarro getStatus() {
        return status;
    }

    public void setStatus(StatusCarro status) {
        this.status = status;
    }

    public MotoristaModel getMotorista() {
        return motorista;
    }

    public void setMotorista(MotoristaModel motorista) {
        this.motorista = motorista;
    }


}
