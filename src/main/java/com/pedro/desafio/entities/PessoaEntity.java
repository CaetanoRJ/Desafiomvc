package com.pedro.desafio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "pessoa")
public class PessoaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date datanascimento;

    private String cpf;

    private boolean funcionario;

    private boolean gerente;

    public PessoaEntity() {
    }

    public PessoaEntity(Long id, String nome, Date datanascimento, boolean funcionario, boolean gerente) {
        this.id = id;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.funcionario = funcionario;
        this.gerente = gerente;
    }

    public PessoaEntity(PessoaDTO pessoa) {
        this.gerente = pessoa.isGerente();
        this.funcionario = false;
        this.nome = pessoa.getNome();

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

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isFuncionario() {
        return funcionario;
    }

    public void setFuncionario(boolean funcionario) {
        this.funcionario = funcionario;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }
}
