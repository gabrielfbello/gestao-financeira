package com.bello.gestaofinanceira.repository;

import com.bello.gestaofinanceira.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

@Repository
public interface LancamentoRepository extends CrudRepository<Lancamento, Long> {
    List<Lancamento> findByDataBetween(Date startDate, Date endDate);

    @Query(value = "SELECT * FROM lancamento ORDER BY data DESC LIMIT 10", nativeQuery = true)
    List<Lancamento> findLast10();

    @Query("SELECT SUM(l.valor) FROM Lancamento l WHERE l.tipo = 'RECEITA'")
    BigDecimal getTotalReceitas();

    @Query("SELECT SUM(l.valor) FROM Lancamento l WHERE l.tipo = 'DESPESA'")
    BigDecimal getTotalDespesas();
}
