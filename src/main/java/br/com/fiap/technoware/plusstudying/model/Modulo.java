package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.AulaController;
import br.com.fiap.technoware.plusstudying.controller.ModuloController;
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
@Table(name = "T_STD_MODULO")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Modulo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @Column(name = "ds_modulo") @NotNull
    @Size(min = 5, max = 100)
    private String modulo;

    public EntityModel<Modulo> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(ModuloController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(ModuloController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(ModuloController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(AulaController.class).show(this.getAula().getId())).withRel("aula") 
        );
    };
}
