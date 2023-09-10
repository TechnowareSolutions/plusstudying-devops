package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.AlternativaController;
import br.com.fiap.technoware.plusstudying.controller.ExercicioController;
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
@Table(name = "T_STD_ALTERNATIVA")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Alternativa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alternativa")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_exercicio")
    private Exercicio exercicio;

    @Column(name = "ds_alternativa") @NotNull
    @Size(min = 3, max = 100, message = "O tamanho da alternativa deve ser entre 3 e 100 caracteres")
    private String alternativa;

    @Column(name = "ds_resposta") @NotNull
    private Character resposta;

    public EntityModel<Alternativa> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(AlternativaController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(AlternativaController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(AlternativaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(ExercicioController.class).show(this.getExercicio().getId())).withRel("exercicio") 
        );
    };
}
