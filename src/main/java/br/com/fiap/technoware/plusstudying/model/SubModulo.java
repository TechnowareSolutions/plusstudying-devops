package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.ModuloController;
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
@Table(name = "T_STD_SUBMODULO")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class SubModulo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_submodulo")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_modulo")
    private Modulo modulo;

    @Column(name = "ds_titulo") @NotNull
    @Size(min = 5, max = 50)
    private String titulo;
    
    @Column(name = "ds_conteudo") @NotNull
    @Size(min = 5, max = 50)
    private String conteudo;
    
    public EntityModel<SubModulo> toEntityModel(){
        return EntityModel.of(
          this,
          linkTo(methodOn(SubModuloController.class).show(this.getId())).withSelfRel(),
          linkTo(methodOn(SubModuloController.class).delete(this.getId())).withRel("delete"),
          linkTo(methodOn(SubModuloController.class).index(null, Pageable.unpaged())).withRel("all"),
          linkTo(methodOn(ModuloController.class).show(this.getModulo().getId())).withRel("submodulo")
        );
      };

}
