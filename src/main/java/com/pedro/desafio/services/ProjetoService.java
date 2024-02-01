package com.pedro.desafio.services;

import com.pedro.desafio.entities.ProjetoDTO;
import com.pedro.desafio.entities.ProjetoEntity;
import com.pedro.desafio.exceptions.DataNotFoundException;

import java.util.List;

public interface ProjetoService {
    List<ProjetoEntity> findAllProjetos();
    public ProjetoEntity update(ProjetoEntity projeto);

    public ProjetoEntity insert(ProjetoEntity projeto);
    public void delete(Long id) throws DataNotFoundException;
    ProjetoEntity getReferenceById(Long id);


}