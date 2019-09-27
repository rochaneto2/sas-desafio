package br.com.teste.tecnico.sasdesafio.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class Simulado extends EntidadeBase<Integer> {

    @JsonProperty(value = "descricao", required = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String descricao;

    @JsonProperty("data")
    @NotNull
    private LocalDate data;

    @JsonCreator
    public Simulado(@JsonProperty @Size(min = 3, max = 255) String descricao,
                    @JsonProperty String data) {
        this.descricao = descricao;
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
