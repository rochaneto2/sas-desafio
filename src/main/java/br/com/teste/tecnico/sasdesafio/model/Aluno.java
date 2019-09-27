package br.com.teste.tecnico.sasdesafio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aluno extends EntidadeBase<Integer> {

    @JsonProperty(value = "nome", required = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String nome;
}
