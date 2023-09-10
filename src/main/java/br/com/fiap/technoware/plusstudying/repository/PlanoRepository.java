package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long>{
    Page<Plano> findByNomeContaining(String search, Pageable pageable);
}