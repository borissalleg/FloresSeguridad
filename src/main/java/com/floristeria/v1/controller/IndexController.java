package com.floristeria.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class IndexController {

    @GetMapping("/index")
    public String home() {
        return "index"; // Nombre de la vista
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Devuelve la plantilla login.html en src/main/resources/templates
    }
}
