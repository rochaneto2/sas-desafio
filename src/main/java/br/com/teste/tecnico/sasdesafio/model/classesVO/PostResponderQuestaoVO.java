package br.com.teste.tecnico.sasdesafio.model.classesVO;

import br.com.teste.tecnico.sasdesafio.model.Item;
import br.com.teste.tecnico.sasdesafio.model.enums.DificuldadeQuestaoEnum;
import br.com.teste.tecnico.sasdesafio.model.enums.OpcaoItemEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class PostResponderQuestaoVO implements Serializable {

    @JsonProperty(value = "idQuestao", required = true)
    @NotNull
    private Integer idQuestao;

    @JsonProperty(value = "opcao", required = true)
    @NotNull
    private OpcaoItemEnum opcao;

    @JsonCreator
    public PostResponderQuestaoVO(@NotNull Integer idQuestao, @NotNull OpcaoItemEnum opcao) {
        this.idQuestao = idQuestao;
        this.opcao = opcao;
    }

    public OpcaoItemEnum getOpcao() {
        return opcao;
    }
}
