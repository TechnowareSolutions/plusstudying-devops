package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.CronogramaController;
import br.com.fiap.technoware.plusstudying.controller.MateriaController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_STD_MATERIA")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Materia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_cronograma")
    private Cronograma cronograma;

    @Column(name = "nm_materia") @NotNull
    @Size(min = 5, max = 100)
    private String materia;

    @Column(name = "nr_nivel", precision = 5) @NotNull
    @Min(value = 1) @Max(value = 5)
    private Integer nivel;

    public EntityModel<Materia> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(MateriaController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(MateriaController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(MateriaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(CronogramaController.class).show(this.getCronograma().getId())).withRel("cronograma") 
        );
    };
}
