package br.com.fiap.technoware.plusstudying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.technoware.plusstudying.model.GptPrompt;

public interface GptPromptRepository extends JpaRepository<GptPrompt, Long>{

    Page<GptPrompt> findByDescricaoPromptContaining(String search, Pageable pageable);
    // Page<GptPrompt> findByNomeContaining(String search, Pageable pageable);
}