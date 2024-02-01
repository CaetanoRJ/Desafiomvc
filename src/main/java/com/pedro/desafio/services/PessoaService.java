package com.pedro.desafio.services;

import com.pedro.desafio.entities.PessoaDTO;
import com.pedro.desafio.entities.PessoaEntity;

import java.util.List;

public interface PessoaService {
    List<PessoaEntity> findAllPessoas();
    public PessoaEntity update(Long id);

    public PessoaEntity insert(PessoaDTO pessoaData);
    PessoaEntity getReferenceById(Long id);

}