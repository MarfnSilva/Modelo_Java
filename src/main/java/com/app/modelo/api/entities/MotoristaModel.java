package com.app.modelo.api.entities;

import com.app.modelo.api.enums.StatusMotorista;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
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

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StatusMotorista status;

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

    public StatusMotorista getStatus() { return status; }

    public void setStatus(StatusMotorista status) { this.status = status; }
}
