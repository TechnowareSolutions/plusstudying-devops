package br.com.fiap.technoware.plusstudying.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.PagamentoController;

@Entity
@Table(name = "T_STD_PAGAMENTO")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Pagamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long id;

    @NotNull @PastOrPresent
    @Column(name = "dt_pagamento")
    private LocalDate data;

    @Column(name = "vl_pagamento") @NotNull
    private BigDecimal valorPagamento;

    @Column(name = "ds_status_pagamento") @NotNull
    @Size(min = 1, max = 2)
    private String statusPagamento;
    
    public EntityModel<Pagamento> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(PagamentoController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(PagamentoController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(PagamentoController.class).index(null, Pageable.unpaged())).withRel("all")      
        );
    };
}
