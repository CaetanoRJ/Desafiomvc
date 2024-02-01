package com.pedro.desafio.services.Impl;

import com.pedro.desafio.entities.PessoaDTO;
import com.pedro.desafio.entities.PessoaEntity;
import com.pedro.desafio.exceptions.PessoaNotFoundException;
import com.pedro.desafio.repositories.PessoaRepository;
import com.pedro.desafio.services.PessoaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    @Override
    public List<PessoaEntity> findAllPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public PessoaEntity insert(PessoaDTO pessoaData){
        PessoaEntity novaPessoa = new PessoaEntity(pessoaData);
        this.pessoaRepository.save(novaPessoa);
        return novaPessoa;
    }
    @Override
    public PessoaEntity getReferenceById(Long id) {
        return pessoaRepository.getReferenceById(id);
    }
    @Override
    public PessoaEntity update(Long id){
        PessoaEntity pessoa = this.pessoaRepository.findById(id)
                .orElseThrow(PessoaNotFoundException::new);

        this.pessoaRepository.save(pessoa);
        return pessoa;
    }


}