package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Classificacao;
import br.com.teste.tecnico.sasdesafio.model.Simulado;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioClassificacao extends FullEntityRepository<Classificacao, Integer> {
}
