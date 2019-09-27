package br.com.teste.tecnico.sasdesafio.model.classesVO;

import br.com.teste.tecnico.sasdesafio.model.enums.OpcaoItemEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

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

    public Integer getIdQuestao() {
        return idQuestao;
    }
}
