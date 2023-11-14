package com.bello.gestaofinanceira.controller;

import com.bello.gestaofinanceira.model.Categoria;
import com.bello.gestaofinanceira.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "categoria/lista";
    }

    @GetMapping("/novo")
    public String exibirFormularioDeNovaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/formulario";
    }

    @PostMapping
    public String salvarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }
}
