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
import br.com.fiap.technoware.plusstudying.model.Cronograma;
import br.com.fiap.technoware.plusstudying.model.Usuario;
import br.com.fiap.technoware.plusstudying.repository.UsuarioRepository;
import br.com.fiap.technoware.plusstudying.repository.CronogramaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/cronograma")
public class CronogramaController {
    @Autowired
    CronogramaRepository cronogramaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) Usuario search, @PageableDefault(size = 5) Pageable pageable){
        var cronogramas = (search == null) ? cronogramaRepository.findAll(pageable) : cronogramaRepository.findByUsuarioContaining(search, pageable);
        return assembler.toModel(cronogramas.map(Cronograma::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Cronograma> show(@PathVariable Long id){
        var cronogramaOptional = getCronograma(id);
        log.info("Listando cronograma: " + id);
        return ResponseEntity.ok(cronogramaOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Cronograma>> create(@RequestBody @Valid Cronograma cronograma, BindingResult result){
        log.info("Cronograma criado com sucesso! " + cronograma);
        cronogramaRepository.save(cronograma);
        cronograma.setUsuario(usuarioRepository.findById(cronograma.getUsuario().getId()).get());
        return ResponseEntity.created(cronograma.toEntityModel().getRequiredLink("self").toUri()).body(cronograma.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Cronograma> delete(@PathVariable Long id){
        var cronogramaOptional = getCronograma(id);
        log.info("Cronograma deletado com sucesso! " + id);
        cronogramaRepository.delete(cronogramaOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Cronograma> update(@PathVariable Long id, @RequestBody @Valid Cronograma cronograma, BindingResult result){
        getCronograma(id);
        log.info("Cronograma atualizado com sucesso! " + cronograma);
        cronograma.setId(id);
        cronogramaRepository.save(cronograma);
        return ResponseEntity.ok(cronograma);
    }

    private Cronograma getCronograma(Long id) {
        return cronogramaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Cronograma não encontrado!"));
    }
}
