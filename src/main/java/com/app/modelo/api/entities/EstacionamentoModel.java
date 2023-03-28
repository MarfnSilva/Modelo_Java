package com.app.modelo.api.entities;

import com.app.modelo.api.enums.StatusEstacionamento;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Estacionamento")
public class EstacionamentoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataInicial;

    private LocalDateTime dataFinal;

    private String preco;

    private String vaga;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StatusEstacionamento status;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private CarroModel carro;

    public EstacionamentoModel(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
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

    public String getVaga() { return vaga; }

    public void setVaga(String vaga) { this.vaga = vaga; }

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
