package com.pedro.desafio.service;

import com.pedro.desafio.entities.ProjetoEntity;
import com.pedro.desafio.repositories.ProjetoRepository;
import com.pedro.desafio.services.Impl.ProjetoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjetoServiceImplTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @InjectMocks
    private ProjetoServiceImpl projetoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAllProjetos() {
        // Given
        List<ProjetoEntity> projetos = Arrays.asList(
                new ProjetoEntity(1L, "Projeto 1", new Date(), new Date(), new Date(), "Descrição", "Em Andamento", 1000.0, "Baixo", 1L)
        );
        when(projetoRepository.findAll()).thenReturn(projetos);

        // When
        List<ProjetoEntity> result = projetoService.findAllProjetos();

        // Then
        assertEquals(projetos, result);
    }

    @Test
    void testInsert() {
        // Given
        ProjetoEntity projeto = new ProjetoEntity(1L, "Projeto 1", new Date(), new Date(), new Date(), "Descrição", "Em Andamento", 1000.0, "Baixo", 1L);

        // When
        when(projetoRepository.save(any(ProjetoEntity.class))).thenReturn(projeto);
        ProjetoEntity result = projetoService.insert(projeto);

        // Then
        assertEquals(projeto, result);
        verify(projetoRepository, times(1)).save(any(ProjetoEntity.class));
    }

    @Test
    void testGetReferenceById() {
        // Given
        Long id = 1L;
        ProjetoEntity projeto = new ProjetoEntity(1L, "Projeto 1", new Date(), new Date(), new Date(), "Descrição", "Em Andamento", 1000.0, "Baixo", 1L);
        when(projetoRepository.getReferenceById(id)).thenReturn(projeto);

        // When
        ProjetoEntity result = projetoService.getReferenceById(id);

        // Then
        assertEquals(projeto, result);
    }

    @Test
    void testUpdate() {
        // Given
        ProjetoEntity projetoEntity = new ProjetoEntity(1L, "Projeto 1", new Date(), new Date(), new Date(), "Descrição", "Em Andamento", 1000.0, "Baixo", 1L);
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projetoEntity));

        // When
        ProjetoEntity updatedProjeto = new ProjetoEntity(1L, "Projeto 1", new Date(), new Date(), new Date(), "Descrição", "Em Andamento", 1000.0, "Baixo", 1L);
        when(projetoRepository.save(any(ProjetoEntity.class))).thenReturn(updatedProjeto);
        ProjetoEntity result = projetoService.update(updatedProjeto);

        // Then
        verify(projetoRepository, times(1)).findById(1L);
        verify(projetoRepository, times(1)).save(any(ProjetoEntity.class));
    }


}