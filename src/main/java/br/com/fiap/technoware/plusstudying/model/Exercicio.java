package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.ExercicioController;
import br.com.fiap.technoware.plusstudying.controller.SubModuloController;
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
@Table(name = "T_STD_EXERCICIO")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Exercicio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercicio")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_submodulo")
    private SubModulo subModulo;

    @Column(name = "ds_titulo") @NotNull
    @Size(min = 5, max = 50)
    private String titulo;

    @Column(name = "ds_pergunta") @NotNull
    @Size(min = 5, max = 50)
    private String pergunta;

    public EntityModel<Exercicio> toEntityModel(){
        return EntityModel.of(
          this,
          linkTo(methodOn(ExercicioController.class).show(this.getId())).withSelfRel(),
          linkTo(methodOn(ExercicioController.class).delete(this.getId())).withRel("delete"),
          linkTo(methodOn(ExercicioController.class).index(null, Pageable.unpaged())).withRel("all"),
          linkTo(methodOn(SubModuloController.class).show(this.getSubModulo().getId())).withRel("submodulo")
        );
      };
}
