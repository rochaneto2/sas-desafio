package br.com.teste.tecnico.sasdesafio.api.recurso;

import br.com.teste.tecnico.sasdesafio.api.servico.ServicoAluno;
import br.com.teste.tecnico.sasdesafio.model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/alunos"})
public class RecursoAluno {

    private ServicoAluno servicoAluno;

    RecursoAluno(ServicoAluno servicoAluno) {
        this.servicoAluno = servicoAluno;
    }

    @GetMapping
    public List<Aluno> listar() {
        return servicoAluno.listarAlunos();
    }

    @PostMapping
    public Aluno salvar(@Valid @RequestBody Aluno aluno) {
        return servicoAluno.salvarAluno(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Integer id,
                                           @Valid @RequestBody Aluno aluno) {
        return ResponseEntity.ok(servicoAluno.atualizarAluno(id, aluno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoAluno.buscarAlunoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Integer id) {
        servicoAluno.removerAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
