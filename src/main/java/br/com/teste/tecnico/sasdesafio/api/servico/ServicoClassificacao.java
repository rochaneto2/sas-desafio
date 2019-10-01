package br.com.teste.tecnico.sasdesafio.api.servico;

import br.com.teste.tecnico.sasdesafio.api.repositorio.RepositorioClassificacao;
import br.com.teste.tecnico.sasdesafio.model.Classificacao;
import br.com.teste.tecnico.sasdesafio.model.classesVO.ClassificacaoRankingVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

import static io.vavr.control.Option.ofOptional;

@Service
public class ServicoClassificacao {

    private RepositorioClassificacao repositorioClassificacao;

    ServicoClassificacao(RepositorioClassificacao repositorioClassificacao) {
        this.repositorioClassificacao = repositorioClassificacao;
    }

    public List<Classificacao> listarClassificacaos() {
        return repositorioClassificacao.findAll();
    }

    public Classificacao buscarClassificacaoPorId(Integer id) {
        return ofOptional(repositorioClassificacao.findById(id)).getOrElseThrow(() -> {
            throw new NoResultException("Não existe uma Classificação com o ID especificado!");
        });
    }

    @Transactional
    public Classificacao salvarClassificacao(Classificacao classificacao) {
        return repositorioClassificacao.saveAndFlush(classificacao);
    }

    @Transactional
    public Classificacao atualizarClassificacao(Integer id, Classificacao classificacao) {
        Classificacao existente = buscarClassificacaoPorId(id);

        BeanUtils.copyProperties(classificacao, existente, "id");

        salvarClassificacao(existente);

        return existente;
    }

    public void removerClassificacaoPorId(Integer id) {
        repositorioClassificacao.delete(buscarClassificacaoPorId(id));
    }

    @Transactional
    public List<ClassificacaoRankingVO> buscarClassificacaoPorSimulado(Integer idSimulado, Integer limite) {
        List<ClassificacaoRankingVO> classificacaoRanking = repositorioClassificacao.buscarClassificacaoPorSimulado(idSimulado, PageRequest.of(0, limite));
        List<Integer> ranking = repositorioClassificacao.buscarRankingSimulado(idSimulado, limite);
        int posicaoRanking = 0;
        for (ClassificacaoRankingVO classificacao : classificacaoRanking) {
            classificacao.setPosRanking(ranking.get(posicaoRanking));
            posicaoRanking = posicaoRanking + 1;
        }
        return classificacaoRanking;
    }
}
