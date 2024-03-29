package br.com.teste.tecnico.sasdesafio.model.classesVO;

import br.com.teste.tecnico.sasdesafio.model.Aluno;
import br.com.teste.tecnico.sasdesafio.model.Simulado;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ClassificacaoRankingVO implements Serializable {

    @JsonProperty(value = "id")
    @NotNull
    private Integer id;

    @JsonProperty(value = "nota")
    @NotNull
    @Max(value = 1000)
    @Min(value = 1)
    private Integer nota;

    @JsonProperty(value = "simulado")
    @Valid
    @NotNull
    private Simulado simulado;

    @JsonProperty(value = "aluno")
    @Valid
    @NotNull
    private Aluno aluno;

    @JsonProperty(value = "posRanking")
    @NotNull
    private Integer posRanking;

    @JsonCreator
    public ClassificacaoRankingVO(@JsonProperty("id") @NotNull Integer id,
                                  @JsonProperty("nota") @NotNull @Max(value = 1000) @Min(value = 1) Integer nota,
                                  @JsonProperty("simulado") @Valid @NotNull Simulado simulado,
                                  @JsonProperty("aluno") @Valid @NotNull Aluno aluno,
                                  @JsonProperty("posRanking") @NotNull Integer posRanking) {
        this.id = id;
        this.nota = nota;
        this.simulado = simulado;
        this.aluno = aluno;
        this.posRanking = posRanking;
    }

    public void setPosRanking(Integer posRanking) {
        this.posRanking = posRanking;
    }
}
