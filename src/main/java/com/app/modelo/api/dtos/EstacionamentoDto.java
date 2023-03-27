package com.app.modelo.api.dtos;

import com.app.modelo.api.entities.CarroModel;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public class EstacionamentoDto {

    private LocalDateTime dataInicial;

    private LocalDateTime dataFinal;

    private String preco;

    private String status;

    private CarroModel carro;

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataIncial) {
        this.dataInicial = dataIncial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CarroModel getCarro() {
        return carro;
    }

    public void setCarro(CarroModel carro) {
        this.carro = carro;
    }
}
