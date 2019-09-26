package br.com.teste.tecnico.sasdesafio.model.classesVO;

import br.com.teste.tecnico.sasdesafio.model.enums.OpcaoItemEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GabaritoVO implements Serializable {

    @JsonProperty(value = "gabarito")
    private OpcaoItemEnum gabarito;

    @JsonProperty(value = "id")
    private Integer id;

    @JsonCreator
    public GabaritoVO(@JsonProperty Integer id, @JsonProperty OpcaoItemEnum gabarito) {
        this.id = id;
        this.gabarito = gabarito;
    }
}
