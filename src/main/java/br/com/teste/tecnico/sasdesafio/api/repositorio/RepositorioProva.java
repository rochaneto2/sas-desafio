package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Prova;
import br.com.teste.tecnico.sasdesafio.model.Questao;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProva extends FullEntityRepository<Prova, Integer> {
}
