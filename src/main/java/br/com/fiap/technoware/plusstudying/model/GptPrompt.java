package br.com.fiap.technoware.plusstudying.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.sql.Blob;
import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.technoware.plusstudying.controller.CronogramaController;
import br.com.fiap.technoware.plusstudying.controller.GptPromptController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_STD_GPTPROMPT")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class GptPrompt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prompt")
    private Long id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_cronograma")
    private Cronograma cronograma;

    @Column(name = "dt_prompt")
    @NotNull @PastOrPresent
    private LocalDate dataPrompt;

    @Column(name = "ds_prompt") @NotNull
    @Size(min = 3, max = 150)
    private String descricaoPrompt;

    @Column(name = "gpt_choices") @NotNull @Lob
    private String gptChoices;

    @Column(name = "gpt_created", precision = 100) @NotNull
    private Long gptCreated;

    @Column(name = "gpt_id") @NotNull
    @Size(min = 3, max = 150)
    private String gptId;

    @Column(name = "gpt_model") @NotNull
    @Size(min = 3, max = 150)
    private String gptModel;

    @Column(name = "gpt_object") @NotNull
    @Size(min = 3, max = 150)
    private String gptObject;

    @Column(name = "gpt_compl_tokens", precision = 100) @NotNull
    @Min(0) @Max(1000)
    private Long gptComplTokens;

    @Column(name = "gpt_prompt_tokens") @NotNull
    @Min(0) @Max(1000)
    private Long gptPromptTokens;

    @Column(name = "gpt_total_tokens") @NotNull
    @Min(0) @Max(1000)
    private Long gptTotalTokens;

    public EntityModel<GptPrompt> toEntityModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(GptPromptController.class).show(this.getId())).withSelfRel(),
            linkTo(methodOn(GptPromptController.class).delete(this.getId())).withRel("delete"),
            linkTo(methodOn(GptPromptController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(CronogramaController.class).show(this.getCronograma().getId())).withRel("cronograma") 
        );
    };

}
