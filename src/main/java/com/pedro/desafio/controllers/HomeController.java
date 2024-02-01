package com.pedro.desafio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @RequestMapping("/")
    public String viewHome()
    {
        return "projetosListar";
    }

}
