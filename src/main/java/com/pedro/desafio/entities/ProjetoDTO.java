package com.pedro.desafio.entities;

import java.util.Date;

import lombok.Data;

@Data
public class ProjetoDTO {
    private long id;
    private String nome;
    private Date dataInicio;
    private Date dataPrevisaoFim;
    private Date dataFim;
    private String descricao;
    private String status;
    private double orcamento;
    private String risco;
    private long idGerente;

}
