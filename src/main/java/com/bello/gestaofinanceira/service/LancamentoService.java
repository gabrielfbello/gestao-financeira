package com.bello.gestaofinanceira.service;

import com.bello.gestaofinanceira.model.Lancamento;
import com.bello.gestaofinanceira.model.TipoLancamento;
import com.bello.gestaofinanceira.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> findAll() {
        return (List<Lancamento>) lancamentoRepository.findAll();
    }

    public Lancamento findById(Long id) {
        return lancamentoRepository.findById(id).orElse(null);
    }

    public Lancamento save(Lancamento lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    public void delete(Long id) {
        lancamentoRepository.deleteById(id);
    }

    public List<Lancamento> findByDataBetween(Date dataInicio, Date dataFim) {
        return lancamentoRepository.findByDataBetween(dataInicio, dataFim);
    }

    public BigDecimal getTotalReceitas() {
        return lancamentoRepository.getTotalReceitas();
    }

    public List<Lancamento> findLast10() {
        return lancamentoRepository.findLast10();
    }

    public BigDecimal getTotalDespesas() {
        Iterable<Lancamento> lancamentos = lancamentoRepository.findAll();
        return StreamSupport.stream(lancamentos.spliterator(), false)
                .filter(l -> l.getTipo() == TipoLancamento.DESPESA)
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}