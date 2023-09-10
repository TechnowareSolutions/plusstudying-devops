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
import br.com.fiap.technoware.plusstudying.model.SubModulo;
import br.com.fiap.technoware.plusstudying.repository.SubModuloRepository;
import br.com.fiap.technoware.plusstudying.repository.ModuloRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/submodulo")
public class SubModuloController {
    @Autowired
    SubModuloRepository subModuloRepository;

    @Autowired
    ModuloRepository moduloRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var submodulos = (search == null) ? subModuloRepository.findAll(pageable) : subModuloRepository.findByTituloContaining(search, pageable);
        return assembler.toModel(submodulos.map(SubModulo::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<SubModulo> show(@PathVariable Long id){
        var subModuloOptional = getSubModulo(id);
        log.info("Listando subModulo: " + id);
        return ResponseEntity.ok(subModuloOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<SubModulo>> create(@RequestBody @Valid SubModulo subModulo, BindingResult result){
        log.info("SubModulo criado com sucesso! " + subModulo);
        subModuloRepository.save(subModulo);
        subModulo.setModulo(moduloRepository.findById(subModulo.getModulo().getId()).get());
        return ResponseEntity.created(subModulo.toEntityModel().getRequiredLink("self").toUri()).body(subModulo.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<SubModulo> delete(@PathVariable Long id){
        var subModuloOptional = getSubModulo(id);
        log.info("SubModulo deletado com sucesso! " + id);
        subModuloRepository.delete(subModuloOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<SubModulo> update(@PathVariable Long id, @RequestBody @Valid SubModulo subModulo, BindingResult result){
        getSubModulo(id);
        log.info("SubModulo atualizado com sucesso! " + subModulo);
        subModulo.setId(id);
        subModuloRepository.save(subModulo);
        return ResponseEntity.ok(subModulo);
    }

    private SubModulo getSubModulo(Long id) {
        return subModuloRepository.findById(id).orElseThrow(() -> new RestNotFoundException("SubModulo não encontrado!"));
    }
}
