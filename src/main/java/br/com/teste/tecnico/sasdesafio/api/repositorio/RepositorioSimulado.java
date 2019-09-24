package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Prova;
import br.com.teste.tecnico.sasdesafio.model.Simulado;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSimulado extends FullEntityRepository<Simulado, Integer> {
}
