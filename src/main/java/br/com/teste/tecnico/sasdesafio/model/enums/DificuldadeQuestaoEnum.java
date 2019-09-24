package br.com.teste.tecnico.sasdesafio.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum DificuldadeQuestaoEnum {

    FACIL(15),
    MEDIA(12),
    DIFICIL(8);

    private final int codigo;

    DificuldadeQuestaoEnum(int codigo) {
        this.codigo = codigo;
    }

    @JsonCreator
    public static DificuldadeQuestaoEnum paraValor(Integer valor) {
        return Stream.of(values()).filter(v -> v.codigo == valor).findFirst().get();
    }

    @JsonValue
    public int getCodigo() {
        return this.codigo;
    }

}
