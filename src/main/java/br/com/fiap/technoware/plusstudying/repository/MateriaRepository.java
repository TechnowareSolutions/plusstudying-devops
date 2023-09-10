package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>{

    Page<Materia> findByMateriaContaining(String search, Pageable pageable);
    // Page<Materia> findByNomeContaining(String search, Pageable pageable);
}
