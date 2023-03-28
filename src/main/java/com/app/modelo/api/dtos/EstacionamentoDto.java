package com.app.modelo.api.dtos;

import com.app.modelo.api.entities.CarroModel;
import com.app.modelo.api.enums.StatusEstacionamento;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public class EstacionamentoDto {

    private LocalDateTime dataInicial;

    private LocalDateTime dataFinal;

    private String preco;

    private String vaga;

    private StatusEstacionamento status;

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

    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public StatusEstacionamento getStatus() {
        return status;
    }

    public void setStatus(StatusEstacionamento status) {
        this.status = status;
    }

    public CarroModel getCarro() {
        return carro;
    }

    public void setCarro(CarroModel carro) {
        this.carro = carro;
    }
}
