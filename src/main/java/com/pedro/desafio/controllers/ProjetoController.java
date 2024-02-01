package com.pedro.desafio.controllers;


import com.pedro.desafio.entities.ProjetoEntity;
import com.pedro.desafio.exceptions.DataNotFoundException;
import com.pedro.desafio.services.ProjetoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjetoController {

    private static final String REDIRECT_LISTAR_PROJETO = "redirect:/listarProjetos";
    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping("/listarProjetos")
    public String mostrarDatos(Model model) {
        List<ProjetoEntity> projetos = projetoService.findAllProjetos();
        model.addAttribute("projetos", projetos);
        return "projetosListar";
    }

    @GetMapping("adicionarProjeto")
    public String  addProjeto()
    {
        return "adicionarProjeto";
    }


    @PostMapping("/insertProjeto")
    public String insertProjeto(@ModelAttribute("insertEmployee") ProjetoEntity projeto)
    {
        projetoService.insert(projeto);
        return REDIRECT_LISTAR_PROJETO;
    }

    @GetMapping("/editarProjeto/{id}")
    public String lodeEditForm(@PathVariable(value="id") Long id, Model m)
    {
        ProjetoEntity projeto = projetoService.getReferenceById(id);
        m.addAttribute("projeto", projeto);
        m.addAttribute("title", "Editar projeto");
        return "projetosEditar";
    }


    @PostMapping("/editarProjeto/updateProjeto")
    public String updateEmp(@ModelAttribute("updateProjeto") ProjetoEntity projeto)
    {
        projetoService.update(projeto);
        return REDIRECT_LISTAR_PROJETO;
    }

    @GetMapping("/deletarProjeto/{id}")
    public String deleteEmployee(@PathVariable Long id) throws DataNotFoundException {
        try {
            projetoService.delete(id);
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException("Erro ao deletar"+ id,e);
        }
        return REDIRECT_LISTAR_PROJETO;
    }
}
