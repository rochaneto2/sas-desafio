package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Aluno;
import br.com.teste.tecnico.sasdesafio.model.Classificacao;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAluno extends FullEntityRepository<Aluno, Integer> {
}
