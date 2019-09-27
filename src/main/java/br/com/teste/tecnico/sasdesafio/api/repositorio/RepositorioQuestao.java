package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioQuestao extends JpaRepository<Questao, Integer> {

    @Query(value = "SELECT (v.valor) from valor_questao as v where v.nivel like :dificuldade", nativeQuery = true)
    Integer buscarValorDaQuestao(@Param("dificuldade") String dificuldade);
}
