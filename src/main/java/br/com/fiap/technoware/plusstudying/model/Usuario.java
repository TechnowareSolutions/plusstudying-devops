package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.PlanoController;
import br.com.fiap.technoware.plusstudying.controller.UsuarioController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_STD_USUARIO")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;

    @Column(name = "nm_usuario") @NotNull
    @Size(min = 3, max = 150)
    private String nome;

    @NotNull @PastOrPresent
    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "ds_cpf") @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "ds_email") @NotNull
    @Size(min = 5, max = 250)
    private String email;

    @Column(name = "ds_senha") @NotNull
    @Size(min = 5, max = 250)
    private String senha;

    @NotNull @PastOrPresent
    @Column(name = "dt_criacao_login")
    private LocalDate dataCriacaoLogin;

    @Column(name = "ds_status_conta") @NotNull
    @Size(min = 1, max = 1)
    private String statusConta;

    @NotNull @PastOrPresent
    @Column(name = "dt_ultimo_login")
    private LocalDate dataUltimoLogin;

    public EntityModel<Usuario> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(UsuarioController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(UsuarioController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(UsuarioController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(PlanoController.class).show(this.getPlano().getId())).withRel("plano") 
        );
    };
}
