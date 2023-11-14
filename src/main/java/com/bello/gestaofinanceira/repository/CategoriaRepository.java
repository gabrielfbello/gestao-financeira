package com.bello.gestaofinanceira.repository;

import com.bello.gestaofinanceira.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> { }
