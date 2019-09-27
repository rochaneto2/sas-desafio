package br.com.teste.tecnico.sasdesafio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Classificacao extends EntidadeBase<Integer> {

    @JsonProperty(value = "nota")
    @NotNull
    @Max(value = 1000)
    @Min(value = 1)
    private Integer nota;

    @JsonProperty(value = "simulado")
    @Valid
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_simulado", foreignKey = @ForeignKey(name = "fk_simulado"))
    private Simulado simulado;

    @JsonProperty(value = "aluno")
    @Valid
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_aluno", foreignKey = @ForeignKey(name = "fk_aluno"))
    private Aluno aluno;
}
