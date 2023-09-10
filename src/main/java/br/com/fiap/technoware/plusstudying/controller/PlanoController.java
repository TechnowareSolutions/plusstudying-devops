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
import br.com.fiap.technoware.plusstudying.model.Plano;
import br.com.fiap.technoware.plusstudying.repository.PlanoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/plano")
public class PlanoController {
    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler; 

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var planos = (search == null) ? planoRepository.findAll(pageable) : planoRepository.findByNomeContaining(search, pageable);
        return assembler.toModel(planos.map(Plano::toEntityModel));
    }

    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Plano> show(@PathVariable Long id){
        var planoOptional = getPlano(id);
        log.info("Listando Plano: " + id);
        return ResponseEntity.ok(planoOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Plano>> create(@RequestBody @Valid Plano plano, BindingResult result){
        log.info("Plano criado com sucesso! " + plano);
        planoRepository.save(plano);
        return ResponseEntity.created(plano.toEntityModel().getRequiredLink("self").toUri()).body(plano.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Plano> delete(@PathVariable Long id){
        var planoOptional = getPlano(id);
        log.info("Plano deletado com sucesso! " + id);
        planoRepository.delete(planoOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Plano> update(@PathVariable Long id, @RequestBody @Valid Plano plano, BindingResult result){
        getPlano(id);
        log.info("Plano atualizado com sucesso! " + plano);
        plano.setId(id);
        planoRepository.save(plano);
        return ResponseEntity.ok(plano);
    }

    private Plano getPlano(Long id) {
        return planoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Plano não encontrado!"));
    }
}
