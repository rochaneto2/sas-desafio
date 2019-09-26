package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Classificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioClassificacao extends JpaRepository<Classificacao, Integer> {

    @Query("FROM Classificacao as c join c.simulado as s where s.id = :idSimulado order by c.nota desc")
    List<Classificacao> buscarIdSimulado(@Param("idSimulado")Integer idSimulado, @Param("limite")Integer limite);
}
