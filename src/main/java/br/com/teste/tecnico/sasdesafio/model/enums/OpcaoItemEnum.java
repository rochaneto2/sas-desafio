package br.com.teste.tecnico.sasdesafio.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;

public enum OpcaoItemEnum {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    @JsonProperty("value")
    private String value;

    OpcaoItemEnum(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OpcaoItemEnum fromValue(final JsonNode jsonNode) {
        for (OpcaoItemEnum type : values()) {
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
