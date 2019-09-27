package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Classificacao;
import br.com.teste.tecnico.sasdesafio.model.classesVO.ClassificacaoRankingVO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioClassificacao extends JpaRepository<Classificacao, Integer> {

    @Query("SELECT NEW br.com.teste.tecnico.sasdesafio.model.classesVO.ClassificacaoRankingVO(c.id, c.nota, c.simulado, c.aluno, 0) " +
            "FROM Classificacao as c join c.simulado as s where s.id = :idSimulado order by c.nota desc ")
    List<ClassificacaoRankingVO> buscarClassificacaoPorSimulado(@Param("idSimulado") Integer idSimulado, Pageable pageable);

    @Query(value = "SELECT RANK() OVER (order by nota desc ) from classificacao as c where c.id_simulado = :idSimulado limit :limite", nativeQuery = true)
    List<Integer> buscarRankingSimulado(@Param("idSimulado") Integer idSimulado, @Param("limite") Integer limite);
}
