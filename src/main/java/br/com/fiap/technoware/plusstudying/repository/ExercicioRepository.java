package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{

    Page<Exercicio> findByTituloContaining(String search, Pageable pageable);
    // Page<Exercicio> findByNomeContaining(String search, Pageable pageable);
}
