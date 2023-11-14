package com.bello.gestaofinanceira.controller;

import com.bello.gestaofinanceira.model.Lancamento;
import com.bello.gestaofinanceira.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public String listarLancamentos(Model model) {
        model.addAttribute("lancamentos", lancamentoService.findAll());
        return "lancamento/lista";
    }

    @GetMapping("/novo")
    public String exibirFormularioDeNovoLancamento(Model model) {
        model.addAttribute("lancamento", new Lancamento());
        return "lancamento/formulario";
    }

    @PostMapping
    public String salvarLancamento(@ModelAttribute Lancamento lancamento) {
        lancamentoService.save(lancamento);
        return "redirect:/lancamentos";
    }

    @GetMapping("/filtro")
    public String filtrarLancamentos(@RequestParam("dataInicio") Date dataInicio,
                                     @RequestParam("dataFim") Date dataFim, Model model) {
        model.addAttribute("lancamentos", lancamentoService.findByDataBetween(dataInicio, dataFim));
        return "lancamento/lista";
    }
}