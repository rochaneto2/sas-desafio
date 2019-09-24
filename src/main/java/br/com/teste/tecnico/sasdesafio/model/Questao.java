package br.com.teste.tecnico.sasdesafio.model;

import br.com.teste.tecnico.sasdesafio.model.enums.DificuldadeQuestaoEnum;
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
public class Questao extends EntidadeBase<Integer>{

    @JsonProperty(value = "descricao", required = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String descricao;

    @JsonProperty(value = "dificuldade", required = true)
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private DificuldadeQuestaoEnum dificuldade;

    @JsonProperty(value = "itens")
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Item> itens;
}
