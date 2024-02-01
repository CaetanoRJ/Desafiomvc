package com.pedro.desafio.services.Impl;


import com.pedro.desafio.entities.ProjetoEntity;
import com.pedro.desafio.exceptions.DataNotFoundException;
import com.pedro.desafio.exceptions.PessoaNotFoundException;
import com.pedro.desafio.repositories.ProjetoRepository;
import com.pedro.desafio.services.ProjetoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoServiceImpl(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }
    @Override
    public List<ProjetoEntity> findAllProjetos() {
        return projetoRepository.findAll();
    }

    public ProjetoEntity insert(ProjetoEntity projeto){
        ProjetoEntity novoProjeto = new ProjetoEntity(projeto);
        this.projetoRepository.save(novoProjeto);
        return novoProjeto;
    }
    @Override
    public ProjetoEntity getReferenceById(Long id) {
        return projetoRepository.getReferenceById(id);
    }
    @Override
    public ProjetoEntity update(ProjetoEntity projetoEntity){
        ProjetoEntity projeto = this.projetoRepository.findById(projetoEntity.getId())
                .orElseThrow(PessoaNotFoundException::new);
        this.projetoRepository.save(projetoEntity);
        return projeto;
    }


    public void delete(Long id) throws DataNotFoundException {
        ProjetoEntity projeto = this.projetoRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        if (projeto.getStatus() == "Iniciado" || projeto.getStatus() == "Em andamento" || projeto.getStatus() == "Encerrado") {
            throw new UnsupportedOperationException("nao pode ser excluido um projeto com o status atual");
        }
        this.projetoRepository.delete(projeto);
    }

}