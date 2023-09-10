package br.com.fiap.technoware.plusstudying.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.technoware.plusstudying.exception.RestNotFoundException;
import br.com.fiap.technoware.plusstudying.model.Alternativa;
import br.com.fiap.technoware.plusstudying.repository.AlternativaRepository;
import br.com.fiap.technoware.plusstudying.repository.ExercicioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/alternativa")
public class AlternativaController {
    @Autowired
    AlternativaRepository alternativaRepository;

    @Autowired
    ExercicioRepository exercicioRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var alternativas = (search == null) ? alternativaRepository.findAll(pageable) : alternativaRepository.findByAlternativaContaining(search, pageable);
        return assembler.toModel(alternativas.map(Alternativa::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Alternativa> show(@PathVariable Long id){
        var alternativaOptional = getAlternativa(id);
        log.info("Listando alternativa: " + id);
        return ResponseEntity.ok(alternativaOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Alternativa>> create(@RequestBody @Valid Alternativa alternativa, BindingResult result){
        log.info("Alternativa criado com sucesso! " + alternativa);
        alternativaRepository.save(alternativa);
        alternativa.setExercicio(exercicioRepository.findById(alternativa.getExercicio().getId()).get());
        return ResponseEntity.created(alternativa.toEntityModel().getRequiredLink("self").toUri()).body(alternativa.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Alternativa> delete(@PathVariable Long id){
        var alternativaOptional = getAlternativa(id);
        log.info("Alternativa deletado com sucesso! " + id);
        alternativaRepository.delete(alternativaOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Alternativa> update(@PathVariable Long id, @RequestBody @Valid Alternativa alternativa, BindingResult result){
        getAlternativa(id);
        log.info("Alternativa atualizado com sucesso! " + alternativa);
        alternativa.setId(id);
        alternativaRepository.save(alternativa);
        return ResponseEntity.ok(alternativa);
    }

    private Alternativa getAlternativa(Long id) {
        return alternativaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Alternativa não encontrado!"));
    }
}
