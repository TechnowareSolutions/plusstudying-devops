package br.com.fiap.technoware.plusstudying.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

    Page<Pagamento> findByDataContaining(LocalDate search, Pageable pageable);
    // Page<Pagamento> findByNomeContaining(String search, Pageable pageable);
}
