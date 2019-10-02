package br.com.teste.tecnico.sasdesafio.model.classesVO;

import br.com.teste.tecnico.sasdesafio.model.enums.OpcaoItemEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GabaritoVO implements Serializable {

    @JsonProperty(value = "idQuestao")
    private Integer idQuestao;

    @JsonProperty(value = "gabarito")
    private OpcaoItemEnum gabarito;

    @JsonCreator
    public GabaritoVO(@JsonProperty Integer id, @JsonProperty OpcaoItemEnum gabarito) {
        this.idQuestao = id;
        this.gabarito = gabarito;
    }
}
