package br.com.teste.tecnico.sasdesafio.model.classesVO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SimuladoVO implements Serializable {

    @JsonProperty(value = "descricao", required = true)

    @Size(min = 3, max = 255)
    private String descricao;

    @JsonProperty("data")

    private LocalDate data;

    @JsonCreator
    public SimuladoVO(@JsonProperty  @Size(min = 3, max = 255) String descricao,
                      @JsonProperty  String data) {
        this.descricao = descricao;
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
