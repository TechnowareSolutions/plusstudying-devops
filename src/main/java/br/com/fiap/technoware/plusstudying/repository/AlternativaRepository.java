package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.Alternativa;

public interface AlternativaRepository extends JpaRepository<Alternativa, Long>{
    Page<Alternativa> findByAlternativaContaining(String search, Pageable pageable);
}
