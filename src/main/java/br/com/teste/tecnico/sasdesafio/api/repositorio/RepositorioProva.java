package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Prova;
import br.com.teste.tecnico.sasdesafio.model.classesVO.GabaritoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioProva extends JpaRepository<Prova, Integer> {

    @Query("SELECT new br.com.teste.tecnico.sasdesafio.model.classesVO.GabaritoVO(q.id, q.gabarito) " +
            "from Questao as q JOIN q.prova as p where p.id = :id")
    List<GabaritoVO> buscarGabaritosPorProva(@Param("id") Integer id);

}
