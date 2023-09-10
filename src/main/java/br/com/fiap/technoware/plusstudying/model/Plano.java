package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.math.BigDecimal;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.PlanoController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_STD_PLANO")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Plano {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano")
    private Long id;

    @Column(name = "nm_plano") @NotNull
    @Size(min = 3, max = 20, message = "O nome deve ter entre 3 e 20 caracteres")
    private String nome;

    @Column(name = "vl_preco", precision = 6, scale = 2) @NotNull
    @Min(value = 0, message = "O valor deve ser maior que 0")
    private BigDecimal valor;

    @Column(name = "ds_plano") @NotNull
    @Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres")
    private String descricao;

    public EntityModel<Plano> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(PlanoController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(PlanoController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(PlanoController.class).index(null, Pageable.unpaged())).withRel("all")      
        );
    };
}
