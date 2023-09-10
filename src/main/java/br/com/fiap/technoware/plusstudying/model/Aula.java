package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.AulaController;
import br.com.fiap.technoware.plusstudying.controller.MateriaController;
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
@Table(name = "T_STD_AULA")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Aula {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    @Column(name = "ds_titulo") @NotNull
    @Size(min = 5, max = 100)
    private String titulo;

    @Column(name = "ds_descricao_aula") @NotNull
    @Size(min = 5, max = 100)
    private String descricaoAula;

    public EntityModel<Aula> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(AulaController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(AulaController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(AulaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(MateriaController.class).show(this.getMateria().getId())).withRel("materia") 
        );
    };
}
