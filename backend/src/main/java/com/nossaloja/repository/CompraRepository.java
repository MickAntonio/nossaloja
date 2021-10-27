package com.nossaloja.repository;

import com.nossaloja.model.Categoria;
import com.nossaloja.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
