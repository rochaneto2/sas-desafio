package br.com.teste.tecnico.sasdesafio.model.classesVO;

import br.com.teste.tecnico.sasdesafio.model.Prova;
import br.com.teste.tecnico.sasdesafio.model.Questao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class SimuladoVO implements Serializable {

    private Integer id;
    private String descricao;
    private LocalDate data;
    private List<Prova> provas;

    public SimuladoVO(Integer id, String descricao, LocalDate data, List<Prova> provas) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.provas = provas;
    }
}
