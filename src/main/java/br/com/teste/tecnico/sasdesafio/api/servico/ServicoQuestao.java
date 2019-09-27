package br.com.teste.tecnico.sasdesafio.api.servico;

import br.com.teste.tecnico.sasdesafio.api.repositorio.RepositorioQuestao;
import br.com.teste.tecnico.sasdesafio.model.Questao;
import br.com.teste.tecnico.sasdesafio.model.classesVO.PostResponderQuestaoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

import static io.vavr.control.Option.ofOptional;

@Service
public class ServicoQuestao {

    private RepositorioQuestao repositorioQuestao;

    ServicoQuestao(RepositorioQuestao repositorioQuestao) {
        this.repositorioQuestao = repositorioQuestao;
    }

    public List<Questao> listarQuestaos() {
        return repositorioQuestao.findAll();
    }

    public Questao buscarQuestaoPorId(Integer id) {
        return ofOptional(repositorioQuestao.findById(id)).getOrElseThrow(() -> {
            throw new NoResultException("Não existe uma Questao com o ID especificado!");
        });
    }

    @Transactional
    public Questao salvarQuestao(Questao questao) {
        return repositorioQuestao.saveAndFlush(questao);
    }

    @Transactional
    public Questao atualizarQuestao(Integer id, Questao questao) {
        Questao existente = buscarQuestaoPorId(id);

        BeanUtils.copyProperties(questao, existente, "id");

        salvarQuestao(existente);

        return existente;
    }

    public void removerQuestaoPorId(Integer id) {
        repositorioQuestao.delete(buscarQuestaoPorId(id));
    }

    public String responderQuestao(Integer idQuestao, PostResponderQuestaoVO respostaQuestao) {
        Questao questao = buscarQuestaoPorId(idQuestao);
        Integer valorDaQuestao = buscarValorDaQuestaoPorDificuldade(questao.getDificuldade().getValue());

        if (respostaQuestao.getOpcao() == questao.getGabarito()) {
            return "Parabéns, você acertou! Está questão tinha nível de dificuldade " + questao.getDificuldade() + " com pontuação " + valorDaQuestao + " !";
        } else {
            return "Infelizmente você errou a questão !";
        }
    }

    public Integer buscarValorDaQuestaoPorDificuldade(String dificuldade) {
        return repositorioQuestao.buscarValorDaQuestao(dificuldade);
    }
}
