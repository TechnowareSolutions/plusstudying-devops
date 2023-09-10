package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long>{

    Page<Modulo> findByModuloContaining(String search, Pageable pageable);
    // Page<Modulo> findByNomeContaining(String search, Pageable pageable);
}
