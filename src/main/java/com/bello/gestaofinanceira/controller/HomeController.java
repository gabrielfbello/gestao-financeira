package com.bello.gestaofinanceira.controller;

import com.bello.gestaofinanceira.model.Lancamento;
import com.bello.gestaofinanceira.service.CategoriaService;
import com.bello.gestaofinanceira.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String home(Model model) {
        BigDecimal totalReceitas = lancamentoService.getTotalReceitas();
        BigDecimal totalDespesas = lancamentoService.getTotalDespesas();
        BigDecimal saldoLiquido = totalReceitas.subtract(totalDespesas);

        if (totalReceitas == null) {
            totalReceitas = BigDecimal.ZERO;
        }
        if (totalDespesas == null) {
            totalDespesas = BigDecimal.ZERO;
        }
        if (saldoLiquido == null) {
            saldoLiquido = BigDecimal.ZERO;
        }

        List<Lancamento> ultimosLancamentos = lancamentoService.findLast10();

        model.addAttribute("totalReceitas", totalReceitas);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("saldoLiquido", saldoLiquido);
        model.addAttribute("ultimosLancamentos", ultimosLancamentos);

        return "home";
    }

}
