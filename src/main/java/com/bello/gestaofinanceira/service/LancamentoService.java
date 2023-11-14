package com.bello.gestaofinanceira.service;

import com.bello.gestaofinanceira.model.Lancamento;
import com.bello.gestaofinanceira.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
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
}