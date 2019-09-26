package br.com.teste.tecnico.sasdesafio.api.servico;

import br.com.teste.tecnico.sasdesafio.api.repositorio.RepositorioProva;
import br.com.teste.tecnico.sasdesafio.model.Prova;
import br.com.teste.tecnico.sasdesafio.model.enums.DificuldadeQuestaoEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.*;

import static io.vavr.control.Option.ofOptional;
import static io.vavr.API.Option;

@Service
public class ServicoProva {

    private final int qtdFaceis = 3;
    private final int qtdMedias = 4;
    private final int qtdDificeis = 3;

    private RepositorioProva repositorioProva;

    ServicoProva(RepositorioProva repositorioProva) {
        this.repositorioProva = repositorioProva;
    }

    public List<Prova> listarProvas() {
        return repositorioProva.findAll();
    }

    public Prova buscarProvaPorId(Integer id) {
        return ofOptional(repositorioProva.findById(id)).getOrElseThrow(() -> {
            throw new NoResultException("Não existe uma Prova com o ID especificado!");
        });
    }

    @Transactional
    public Prova salvarProva(Prova prova) {
        verificaQuantidadeDeQuestoes(prova);
        return repositorioProva.saveAndFlush(prova);
    }

    @Transactional
    public Prova atualizarProva(Integer id, Prova prova) {
        Prova existente = buscarProvaPorId(id);

        BeanUtils.copyProperties(prova, existente, "id");

        salvarProva(existente);

        return existente;
    }

    public void removerProvaPorId(Integer id) {
        repositorioProva.delete(buscarProvaPorId(id));
    }

    public boolean verificaQuantidadeDeQuestoes(Prova prova) {
        Map<DificuldadeQuestaoEnum, Integer> quantidadesQuestoes = new HashMap<>();

        prova.getQuestoes().forEach(questao -> {
            if (questao.getDificuldade() == DificuldadeQuestaoEnum.FACIL) {
                quantidadesQuestoes.merge(DificuldadeQuestaoEnum.FACIL, 1, Integer::sum);
            }
            if (questao.getDificuldade() == DificuldadeQuestaoEnum.MEDIA) {
                quantidadesQuestoes.merge(DificuldadeQuestaoEnum.MEDIA, 1, Integer::sum);
            }
            if (questao.getDificuldade() == DificuldadeQuestaoEnum.DIFICIL) {
                quantidadesQuestoes.merge(DificuldadeQuestaoEnum.DIFICIL, 1, Integer::sum);
            }
        });
        if ((Option(quantidadesQuestoes.get(DificuldadeQuestaoEnum.FACIL)).getOrElse(0) != qtdFaceis) &&
                (Option(quantidadesQuestoes.get(DificuldadeQuestaoEnum.MEDIA)).getOrElse(0) != qtdMedias) &&
                (Option(quantidadesQuestoes.get(DificuldadeQuestaoEnum.DIFICIL)).getOrElse(0) != qtdDificeis)){
            throw new NoResultException("As quantidades de questões por dificuldade fogem da regra de negócio!");
        }
        else {
            return true;
        }
    }
}
