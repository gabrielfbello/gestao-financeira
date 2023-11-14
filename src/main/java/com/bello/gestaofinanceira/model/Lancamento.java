package com.bello.gestaofinanceira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private Date data;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo; // TipoLancamento é um enum para RECEITA e DESPESA

    @ManyToOne
    private Categoria categoria;

    // Construtores
    public Lancamento() {
    }

    public Lancamento(BigDecimal valor, Date data, TipoLancamento tipo, Categoria categoria) {
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
