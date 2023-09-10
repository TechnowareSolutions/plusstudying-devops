package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.SubModulo;

public interface SubModuloRepository extends JpaRepository<SubModulo, Long>{

    Page<SubModulo> findByTituloContaining(String search, Pageable pageable);
    // Page<SubModulo> findByNomeContaining(String search, Pageable pageable);
}
