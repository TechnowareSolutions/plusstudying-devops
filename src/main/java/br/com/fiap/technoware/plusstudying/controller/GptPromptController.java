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
import br.com.fiap.technoware.plusstudying.model.GptPrompt;
import br.com.fiap.technoware.plusstudying.repository.GptPromptRepository;
import br.com.fiap.technoware.plusstudying.repository.CronogramaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/gptprompt")
public class GptPromptController {
    @Autowired
    GptPromptRepository gptPromptRepository;

    @Autowired
    CronogramaRepository cronogramaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var gptPrompts = (search == null) ? gptPromptRepository.findAll(pageable) : gptPromptRepository.findByDescricaoPromptContaining(search, pageable);
        return assembler.toModel(gptPrompts.map(GptPrompt::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<GptPrompt> show(@PathVariable Long id){
        var gptPromptOptional = getGptPrompt(id);
        log.info("Listando gptPrompt: " + id);
        return ResponseEntity.ok(gptPromptOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<GptPrompt>> create(@RequestBody @Valid GptPrompt gptPrompt, BindingResult result){
        log.info("GptPrompt criado com sucesso! " + gptPrompt);
        gptPromptRepository.save(gptPrompt);
        gptPrompt.setCronograma(cronogramaRepository.findById(gptPrompt.getCronograma().getId()).get());
        return ResponseEntity.created(gptPrompt.toEntityModel().getRequiredLink("self").toUri()).body(gptPrompt.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<GptPrompt> delete(@PathVariable Long id){
        var gptPromptOptional = getGptPrompt(id);
        log.info("GptPrompt deletado com sucesso! " + id);
        gptPromptRepository.delete(gptPromptOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<GptPrompt> update(@PathVariable Long id, @RequestBody @Valid GptPrompt gptPrompt, BindingResult result){
        getGptPrompt(id);
        log.info("GptPrompt atualizado com sucesso! " + gptPrompt);
        gptPrompt.setId(id);
        gptPromptRepository.save(gptPrompt);
        return ResponseEntity.ok(gptPrompt);
    }

    private GptPrompt getGptPrompt(Long id) {
        return gptPromptRepository.findById(id).orElseThrow(() -> new RestNotFoundException("GptPrompt não encontrado!"));
    }
}
