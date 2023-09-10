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
import br.com.fiap.technoware.plusstudying.model.FormaPagamento;
import br.com.fiap.technoware.plusstudying.repository.FormaPagamentoRepository;
import br.com.fiap.technoware.plusstudying.repository.PagamentoRepository;
import br.com.fiap.technoware.plusstudying.repository.PlanoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/formapagamento")
public class FormaPagamentoController {
    @Autowired
    FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var formaPagamentos = (search == null) ? formaPagamentoRepository.findAll(pageable) : formaPagamentoRepository.findByNomeTitularContaining(search, pageable);
        return assembler.toModel(formaPagamentos.map(FormaPagamento::toEntityModel));
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<FormaPagamento> show(@PathVariable Long id){
        var formaPagamentoOptional = getFormaPagamento(id);
        log.info("Listando formaPagamento: " + id);
        return ResponseEntity.ok(formaPagamentoOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<FormaPagamento>> create(@RequestBody @Valid FormaPagamento formaPagamento, BindingResult result){
        log.info("FormaPagamento criado com sucesso! " + formaPagamento);
        formaPagamentoRepository.save(formaPagamento);
        formaPagamento.setPagamento(pagamentoRepository.findById(formaPagamento.getPagamento().getId()).get());
        formaPagamento.setPlano(planoRepository.findById(formaPagamento.getPlano().getId()).get());
        return ResponseEntity.created(formaPagamento.toEntityModel().getRequiredLink("self").toUri()).body(formaPagamento.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<FormaPagamento> delete(@PathVariable Long id){
        var formaPagamentoOptional = getFormaPagamento(id);
        log.info("FormaPagamento deletado com sucesso! " + id);
        formaPagamentoRepository.delete(formaPagamentoOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<FormaPagamento> update(@PathVariable Long id, @RequestBody @Valid FormaPagamento formaPagamento, BindingResult result){
        getFormaPagamento(id);
        log.info("FormaPagamento atualizado com sucesso! " + formaPagamento);
        formaPagamento.setId(id);
        formaPagamentoRepository.save(formaPagamento);
        return ResponseEntity.ok(formaPagamento);
    }

    private FormaPagamento getFormaPagamento(Long id) {
        return formaPagamentoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("FormaPagamento não encontrado!"));
    }
}
