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
import br.com.fiap.technoware.plusstudying.model.Exercicio;
import br.com.fiap.technoware.plusstudying.repository.ExercicioRepository;
import br.com.fiap.technoware.plusstudying.repository.SubModuloRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/exercicio")
public class ExercicioController {
    @Autowired
    ExercicioRepository exercicioRepository;

    @Autowired
    SubModuloRepository submoduloRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var exercicios = (search == null) ? exercicioRepository.findAll(pageable) : exercicioRepository.findByTituloContaining(search, pageable);
        return assembler.toModel(exercicios.map(Exercicio::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Exercicio> show(@PathVariable Long id){
        var exercicioOptional = getExercicio(id);
        log.info("Listando exercicio: " + id);
        return ResponseEntity.ok(exercicioOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Exercicio>> create(@RequestBody @Valid Exercicio exercicio, BindingResult result){
        log.info("Exercicio criado com sucesso! " + exercicio);
        exercicioRepository.save(exercicio);
        exercicio.setSubModulo(submoduloRepository.findById(exercicio.getSubModulo().getId()).get());
        return ResponseEntity.created(exercicio.toEntityModel().getRequiredLink("self").toUri()).body(exercicio.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Exercicio> delete(@PathVariable Long id){
        var exercicioOptional = getExercicio(id);
        log.info("Exercicio deletado com sucesso! " + id);
        exercicioRepository.delete(exercicioOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Exercicio> update(@PathVariable Long id, @RequestBody @Valid Exercicio exercicio, BindingResult result){
        getExercicio(id);
        log.info("Exercicio atualizado com sucesso! " + exercicio);
        exercicio.setId(id);
        exercicioRepository.save(exercicio);
        return ResponseEntity.ok(exercicio);
    }

    private Exercicio getExercicio(Long id) {
        return exercicioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Exercicio não encontrado!"));
    }
}
