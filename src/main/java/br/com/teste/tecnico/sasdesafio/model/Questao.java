package br.com.teste.tecnico.sasdesafio.model;

import br.com.teste.tecnico.sasdesafio.model.enums.DificuldadeQuestaoEnum;
import br.com.teste.tecnico.sasdesafio.model.enums.OpcaoItemEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "questao")
public class Questao extends EntidadeBase<Integer> {

    @JsonProperty(value = "descricao", required = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String descricao;

    @JsonProperty(value = "dificuldade", required = true)
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private DificuldadeQuestaoEnum dificuldade;

    @JsonProperty(value = "itens")
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "questao", cascade = CascadeType.ALL)
    private List<Item> itens;

    @JsonProperty(value = "gabarito", required = true)
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private OpcaoItemEnum gabarito;

    @ManyToOne
    @JsonIgnore
    @NotNull
    @JoinColumn(name = "id_prova", foreignKey = @ForeignKey(name = "fk_prova"), nullable = false)
    private Prova prova;

    @PostPersist
    private void posInserir() {
        itens.forEach(i -> i.setQuestao(this));
    }

}
