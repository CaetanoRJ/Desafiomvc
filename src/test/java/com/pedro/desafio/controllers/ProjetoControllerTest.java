package com.pedro.desafio.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.pedro.desafio.services.ProjetoService;
import com.pedro.desafio.entities.ProjetoEntity;

@WebAppConfiguration("src/main/webapp/WEB-INF/jsp")
@ExtendWith(MockitoExtension.class)
class ProjetoControllerTest {

    @Mock
    private ProjetoService projetoService;

    @InjectMocks
    private ProjetoController projetoController;

    private MockMvc mockMvc;

    @Test
    void testMostrarDatos() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(projetoController).build();

        when(projetoService.findAllProjetos()).thenReturn(Arrays.asList(new ProjetoEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get("/listarProjetos"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("projetosListar"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("projetos"));
    }


    @Test
    void testInsertProjeto() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(projetoController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/insertProjeto")
                        .param("nome", "Projeto de Teste")
                        .param("descricao", "Descrição do Projeto"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/listarProjetos"));

        // Verifique se o método insert do ProjetoService foi chamado com os parâmetros corretos
        verify(projetoService, times(1)).insert(any(ProjetoEntity.class));
    }

    @Test
    void testLodeEditForm() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(projetoController).build();

        Long id = 1L;
        ProjetoEntity projeto = new ProjetoEntity();
        projeto.setId(id);
        when(projetoService.getReferenceById(id)).thenReturn(projeto);

        mockMvc.perform(MockMvcRequestBuilders.get("/editarProjeto/{id}", id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("projetosEditar"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("projeto"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("title"))
                .andExpect(MockMvcResultMatchers.model().attribute("title", "Editar projeto"));
    }

    @Test
    void testUpdateEmp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(projetoController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/editarProjeto/updateProjeto")
                        .param("id", "1")
                        .param("nome", "Projeto Atualizado")
                        .param("descricao", "Descrição Atualizada"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/listarProjetos"));

        // Verifique se o método update do ProjetoService foi chamado com os parâmetros corretos
        verify(projetoService, times(1)).update(any(ProjetoEntity.class));
    }

    @Test
    void testDeleteEmployee() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(projetoController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/deletarProjeto/{id}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/listarProjetos"));

    }
}
