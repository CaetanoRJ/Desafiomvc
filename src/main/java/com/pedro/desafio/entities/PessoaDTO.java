package com.pedro.desafio.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PessoaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Date datanascimento;
    private String cpf;
    private boolean funcionario;
    private boolean gerente;

    // Construtores, getters e setters...

    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String nome, Date datanascimento, String cpf, boolean funcionario, boolean gerente) {
        this.id = id;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.funcionario = funcionario;
        this.gerente = gerente;
    }

    // Outros getters e setters...

    // Métodos toString, equals e hashCode, se necessário...
}