package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.Cronograma;
import br.com.fiap.technoware.plusstudying.model.Usuario;

public interface CronogramaRepository extends JpaRepository<Cronograma, Long>{

    Page<Cronograma> findByUsuarioContaining(Usuario search, Pageable pageable);
    // Page<Cronograma> findByNomeContaining(String search, Pageable pageable);
}
