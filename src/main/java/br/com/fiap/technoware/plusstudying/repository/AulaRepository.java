package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.Aula;

public interface AulaRepository extends JpaRepository<Aula, Long>{

    Page<Aula> findByTituloContaining(String search, Pageable pageable);
    // Page<Aula> findByNomeContaining(String search, Pageable pageable);
}
