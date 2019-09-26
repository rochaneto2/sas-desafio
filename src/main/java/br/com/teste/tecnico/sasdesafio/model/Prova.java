package br.com.teste.tecnico.sasdesafio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "prova")
public class Prova extends EntidadeBase<Integer> {

    @JsonProperty(value = "simulado")
    @Valid
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_simulado", foreignKey = @ForeignKey(name = "fk_simulado"))
    private Simulado simulado;

    @JsonProperty(value = "questoes")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prova", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Questao> questoes;

    @PostPersist
    private void posInserir() {
        questoes.forEach(i -> i.setProva(this));
    }
}
