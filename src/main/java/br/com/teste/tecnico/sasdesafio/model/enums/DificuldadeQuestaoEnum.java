package br.com.teste.tecnico.sasdesafio.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.stream.Stream;

public enum DificuldadeQuestaoEnum {

    FACIL("FACIL"),
    MEDIA("MEDIA"),
    DIFICIL("DIFICIL");


    @JsonProperty("value")
    private String value;

    DificuldadeQuestaoEnum(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DificuldadeQuestaoEnum fromValue(final JsonNode jsonNode) {
        for (DificuldadeQuestaoEnum type : values()) {
            if (type.value.equals(jsonNode.asText())) {
                return type;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
