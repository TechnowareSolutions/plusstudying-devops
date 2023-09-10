package br.com.fiap.technoware.plusstudying.controller;

import java.time.LocalDate;

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
import br.com.fiap.technoware.plusstudying.model.Pagamento;
import br.com.fiap.technoware.plusstudying.repository.PagamentoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/pagamento")
public class PagamentoController {
    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler; 

    // Get All
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) LocalDate search, @PageableDefault(size = 5) Pageable pageable){
        var pagamentos = (search == null) ? pagamentoRepository.findAll(pageable) : pagamentoRepository.findByDataContaining(search, pageable);
        return assembler.toModel(pagamentos.map(Pagamento::toEntityModel));
    }

    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Pagamento> show(@PathVariable Long id){
        var pagamentoOptional = getPagamento(id);
        log.info("Listando Pagamento: " + id);
        return ResponseEntity.ok(pagamentoOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Pagamento>> create(@RequestBody @Valid Pagamento pagamento, BindingResult result){
        log.info("Pagamento criado com sucesso! " + pagamento);
        pagamentoRepository.save(pagamento);
        return ResponseEntity.created(pagamento.toEntityModel().getRequiredLink("self").toUri()).body(pagamento.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Pagamento> delete(@PathVariable Long id){
        var pagamentoOptional = getPagamento(id);
        log.info("Pagamento deletado com sucesso! " + id);
        pagamentoRepository.delete(pagamentoOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody @Valid Pagamento pagamento, BindingResult result){
        getPagamento(id);
        log.info("Pagamento atualizado com sucesso! " + pagamento);
        pagamento.setId(id);
        pagamentoRepository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }

    private Pagamento getPagamento(Long id) {
        return pagamentoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Pagamento não encontrado!"));
    }
}
