package br.com.teste.tecnico.sasdesafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item extends EntidadeBase<Integer>{

    @JsonProperty(value = "descricao", required = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String descricao;

    @JsonProperty(value = "opcao", required = true)
    @NotNull
    @Size(min = 1, max = 1)
    private Character opcao;

    @ManyToOne
    @JsonIgnore
    @NotNull
    @JoinColumn(name = "id_questao", foreignKey = @ForeignKey(name = "fk_questao"), nullable = false)
    private Questao questao;
}
