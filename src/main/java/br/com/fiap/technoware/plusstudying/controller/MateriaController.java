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
import br.com.fiap.technoware.plusstudying.model.Materia;
import br.com.fiap.technoware.plusstudying.repository.MateriaRepository;
import br.com.fiap.technoware.plusstudying.repository.CronogramaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/materia")
public class MateriaController {
    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    CronogramaRepository cronogramaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var materias = (search == null) ? materiaRepository.findAll(pageable) : materiaRepository.findByMateriaContaining(search, pageable);
        return assembler.toModel(materias.map(Materia::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Materia> show(@PathVariable Long id){
        var materiaOptional = getMateria(id);
        log.info("Listando materia: " + id);
        return ResponseEntity.ok(materiaOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Materia>> create(@RequestBody @Valid Materia materia, BindingResult result){
        log.info("Materia criado com sucesso! " + materia);
        materiaRepository.save(materia);
        materia.setCronograma(cronogramaRepository.findById(materia.getCronograma().getId()).get());
        return ResponseEntity.created(materia.toEntityModel().getRequiredLink("self").toUri()).body(materia.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Materia> delete(@PathVariable Long id){
        var materiaOptional = getMateria(id);
        log.info("Materia deletado com sucesso! " + id);
        materiaRepository.delete(materiaOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Materia> update(@PathVariable Long id, @RequestBody @Valid Materia materia, BindingResult result){
        getMateria(id);
        log.info("Materia atualizado com sucesso! " + materia);
        materia.setId(id);
        materiaRepository.save(materia);
        return ResponseEntity.ok(materia);
    }

    private Materia getMateria(Long id) {
        return materiaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Materia não encontrado!"));
    }
}
