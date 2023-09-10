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
import br.com.fiap.technoware.plusstudying.model.Modulo;
import br.com.fiap.technoware.plusstudying.repository.ModuloRepository;
import br.com.fiap.technoware.plusstudying.repository.AulaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/modulo")
public class ModuloController {
    @Autowired
    ModuloRepository moduloRepository;

    @Autowired
    AulaRepository aulaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var modulos = (search == null) ? moduloRepository.findAll(pageable) : moduloRepository.findByModuloContaining(search, pageable);
        return assembler.toModel(modulos.map(Modulo::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Modulo> show(@PathVariable Long id){
        var moduloOptional = getModulo(id);
        log.info("Listando modulo: " + id);
        return ResponseEntity.ok(moduloOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Modulo>> create(@RequestBody @Valid Modulo modulo, BindingResult result){
        log.info("Modulo criado com sucesso! " + modulo);
        moduloRepository.save(modulo);
        modulo.setAula(aulaRepository.findById(modulo.getAula().getId()).get());
        return ResponseEntity.created(modulo.toEntityModel().getRequiredLink("self").toUri()).body(modulo.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Modulo> delete(@PathVariable Long id){
        var moduloOptional = getModulo(id);
        log.info("Modulo deletado com sucesso! " + id);
        moduloRepository.delete(moduloOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Modulo> update(@PathVariable Long id, @RequestBody @Valid Modulo modulo, BindingResult result){
        getModulo(id);
        log.info("Modulo atualizado com sucesso! " + modulo);
        modulo.setId(id);
        moduloRepository.save(modulo);
        return ResponseEntity.ok(modulo);
    }

    private Modulo getModulo(Long id) {
        return moduloRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Modulo não encontrado!"));
    }
}
