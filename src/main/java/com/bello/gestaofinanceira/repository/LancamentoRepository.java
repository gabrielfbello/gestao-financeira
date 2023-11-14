package com.bello.gestaofinanceira.repository;

import com.bello.gestaofinanceira.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    List<Lancamento> findByDataBetween(Date startDate, Date endDate);
}
