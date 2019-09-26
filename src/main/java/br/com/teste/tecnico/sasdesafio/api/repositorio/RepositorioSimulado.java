package br.com.teste.tecnico.sasdesafio.api.repositorio;

import br.com.teste.tecnico.sasdesafio.model.Prova;
import br.com.teste.tecnico.sasdesafio.model.Simulado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSimulado extends JpaRepository<Simulado, Integer> {

    @Query("SELECT distinct p FROM Prova p JOIN p.questoes q JOIN q.itens q JOIN p.simulado as s " +
            "where s.id =:id")
    List<Prova> bucasTodasAsProvasPorSimulado(@Param("id") Integer id);
}
