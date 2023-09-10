package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{

    Page<FormaPagamento> findByNomeTitularContaining(String search, Pageable pageable);
    // Page<FormaPagamento> findByNomeContaining(String search, Pageable pageable);
}
