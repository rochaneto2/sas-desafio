package br.com.teste.tecnico.sasdesafio.api.servico;

import br.com.teste.tecnico.sasdesafio.api.repositorio.RepositorioAluno;
import br.com.teste.tecnico.sasdesafio.model.Aluno;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

import static io.vavr.control.Option.ofOptional;

@Service
public class ServicoAluno {

    private RepositorioAluno repositorioAluno;

    ServicoAluno(RepositorioAluno repositorioAluno) {
        this.repositorioAluno = repositorioAluno;
    }

    public List<Aluno> listarAlunos() {
        return repositorioAluno.findAll();
    }

    public Aluno buscarAlunoPorId(Integer id) {
        return ofOptional(repositorioAluno.findById(id)).getOrElseThrow(() -> {
            throw new NoResultException("Não existe um aluno com o ID especificado!");
        });
    }

    @Transactional
    public Aluno salvarAluno(Aluno aluno) {
        return repositorioAluno.saveAndFlush(aluno);
    }

    @Transactional
    public Aluno atualizarAluno(Integer id, Aluno aluno) {
        Aluno existente = buscarAlunoPorId(id);

        BeanUtils.copyProperties(aluno, existente, "id");

        salvarAluno(existente);

        return existente;
    }

    public void removerAlunoPorId(Integer id) {
        repositorioAluno.delete(buscarAlunoPorId(id));
    }
}
