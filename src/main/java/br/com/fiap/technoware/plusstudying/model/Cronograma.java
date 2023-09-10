package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.CronogramaController;
import br.com.fiap.technoware.plusstudying.controller.UsuarioController;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_STD_CRONOGRAMA")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Cronograma {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cronograma")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "nr_porcentagem", precision = 3) @NotNull
    @Min(value = 0) @Max(value = 100)
    private Integer porcentagem;

    public EntityModel<Cronograma> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(CronogramaController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(CronogramaController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(CronogramaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(UsuarioController.class).show(this.getUsuario().getId())).withRel("usuario") 
        );
    };
}
