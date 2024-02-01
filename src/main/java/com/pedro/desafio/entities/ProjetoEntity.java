package com.pedro.desafio.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ToString
@Entity
@Table(name = "projeto")
public class ProjetoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_previsao_fim")
    @Temporal(TemporalType.DATE)
    private Date dataPrevisaoFim;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @Column(name = "descricao", length = 5000)
    private String descricao;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "orcamento")
    private double orcamento;

    @Column(name = "risco", length = 45)
    private String risco;

    @Column(name = "idgerente", nullable = false)
    private long idGerente;

    public ProjetoEntity(ProjetoEntity projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.dataInicio = projeto.getDataInicio();
        this.dataPrevisaoFim = projeto.getDataPrevisaoFim();
        this.dataFim = projeto.getDataFim();
        this.descricao = projeto.getDescricao();
        this.status = projeto.getStatus();
        this.orcamento = projeto.getOrcamento();
        this.risco = projeto.getRisco();
        this.idGerente = projeto.getIdGerente();
    }

    public ProjetoEntity(long id, String nome, Date dataInicio, Date dataPrevisaoFim, Date dataFim,
                         String descricao, String status, double orcamento, String risco, long idGerente) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataPrevisaoFim = dataPrevisaoFim;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.status = status;
        this.orcamento = orcamento;
        this.risco = risco;
        this.idGerente = idGerente;
    }

    public ProjetoEntity() {

    }
}
