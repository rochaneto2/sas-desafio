package br.com.teste.tecnico.sasdesafio.model.classesVO;

import br.com.teste.tecnico.sasdesafio.model.Item;
import br.com.teste.tecnico.sasdesafio.model.enums.DificuldadeQuestaoEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class GetResponderQuestaoVO implements Serializable {

    @JsonProperty(value = "id", required = true)
    @NotNull
    private Integer id;

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

    @JsonCreator
    public GetResponderQuestaoVO(@NotNull Integer id, @NotNull @Size(min = 3, max = 255) String descricao, @NotNull DificuldadeQuestaoEnum dificuldade, List<Item> itens) {
        this.id = id;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.itens = itens;
    }
}
