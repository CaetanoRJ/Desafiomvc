package com.pedro.desafio.controllers;

import com.pedro.desafio.entities.PessoaEntity;
import com.pedro.desafio.services.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/listarPessoas")
    public String mostrarDatos(Model model) {
        List<PessoaEntity> pessoas = pessoaService.findAllPessoas();
        model.addAttribute("pessoas", pessoas);
        return "pessoasListar";
    }

    @GetMapping("/editEmployee/{id}")
    public String lodeEditForm(@PathVariable(value="id") Long id, Model m)
    {
        PessoaEntity pessoa = pessoaService.getReferenceById(id);
        m.addAttribute("pessoa", pessoa);
        m.addAttribute("title", "Edit Pessoa");
        return "pessoasEditar";
    }

}
