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
import br.com.fiap.technoware.plusstudying.model.Aula;
import br.com.fiap.technoware.plusstudying.repository.AulaRepository;
import br.com.fiap.technoware.plusstudying.repository.MateriaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/aula")
public class AulaController {
    @Autowired
    AulaRepository aulaRepository;

    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var aulas = (search == null) ? aulaRepository.findAll(pageable) : aulaRepository.findByTituloContaining(search, pageable);
        return assembler.toModel(aulas.map(Aula::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Aula> show(@PathVariable Long id){
        var aulaOptional = getAula(id);
        log.info("Listando aula: " + id);
        return ResponseEntity.ok(aulaOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Aula>> create(@RequestBody @Valid Aula aula, BindingResult result){
        log.info("Aula criado com sucesso! " + aula);
        aulaRepository.save(aula);
        aula.setMateria(materiaRepository.findById(aula.getMateria().getId()).get());
        return ResponseEntity.created(aula.toEntityModel().getRequiredLink("self").toUri()).body(aula.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Aula> delete(@PathVariable Long id){
        var aulaOptional = getAula(id);
        log.info("Aula deletado com sucesso! " + id);
        aulaRepository.delete(aulaOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Aula> update(@PathVariable Long id, @RequestBody @Valid Aula aula, BindingResult result){
        getAula(id);
        log.info("Aula atualizado com sucesso! " + aula);
        aula.setId(id);
        aulaRepository.save(aula);
        return ResponseEntity.ok(aula);
    }

    private Aula getAula(Long id) {
        return aulaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Aula não encontrado!"));
    }
}
