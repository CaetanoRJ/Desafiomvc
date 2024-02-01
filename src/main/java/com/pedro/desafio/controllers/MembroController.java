package com.pedro.desafio.controllers;

import com.pedro.desafio.entities.PessoaDTO;
import com.pedro.desafio.entities.PessoaEntity;
import com.pedro.desafio.services.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/membro")
public class MembroController {
    private final PessoaService pessoaService;

    public MembroController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaEntity> insert(@RequestBody PessoaDTO pessoaData){
        PessoaEntity novaPessoa = this.pessoaService.insert(pessoaData);
        return ResponseEntity.ok().body(novaPessoa);
    }

}
