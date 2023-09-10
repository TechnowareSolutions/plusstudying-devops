package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.FormaPagamentoController;
import br.com.fiap.technoware.plusstudying.controller.PagamentoController;
import br.com.fiap.technoware.plusstudying.controller.PlanoController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_STD_FORMA_PAGAMENTO")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class FormaPagamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pagamento")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;

    @Column(name = "nm_titular") @NotNull
    @Size(min = 3, max = 150)
    private String nomeTitular;

    @Column(name = "nr_cpf") @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "nr_cartao", precision = 16)
    private Long numeroCartao;

    @Column(name = "dt_validade")
    private LocalDate dataValidade;

    @Column(name = "nr_cvv", precision = 3)
    private Integer cvv;

    public EntityModel<FormaPagamento> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(FormaPagamentoController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(FormaPagamentoController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(FormaPagamentoController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(PagamentoController.class).show(this.getPagamento().getId())).withRel("pagamento"), 
            linkTo(methodOn(PlanoController.class).show(this.getPlano().getId())).withRel("plano") 
        );
    };

}
