package br.com.teste.tecnico.sasdesafio.model.classesVO;

import br.com.teste.tecnico.sasdesafio.model.Aluno;
import br.com.teste.tecnico.sasdesafio.model.Simulado;
import br.com.teste.tecnico.sasdesafio.model.enums.OpcaoItemEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @JsonProperty(value = "posRanking")
    @NotNull
    private Integer posRanking;

    public void setPosRanking(Integer posRanking) {
        this.posRanking = posRanking;
    }

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
}
