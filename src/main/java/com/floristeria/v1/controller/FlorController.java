package com.floristeria.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.floristeria.v1.Service.FlorService;
import com.floristeria.v1.model.Flores;

@Controller
@RequestMapping("/flores")
public class FlorController {
    
    @Autowired 
    private FlorService florService;

    @GetMapping("/listar")
    public String listarFLores(Model model){
         model.addAttribute("flores",florService.listarFlores());
        return "listarFlores";
    }
    @GetMapping("/agregar") 
    public String mostrarFormulario(Model model){
        model.addAttribute("flores", new Flores());
        return "floresForm";
    }

    @PostMapping("/guardar")
    public String guardarFlor(@ModelAttribute Flores flores){
        florService.guardarFlor(flores);
       return "redirect:/flores/listar";
    }

}
