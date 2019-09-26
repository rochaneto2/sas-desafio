package br.com.teste.tecnico.sasdesafio.api.recurso;

import br.com.teste.tecnico.sasdesafio.api.servico.ServicoQuestao;
import br.com.teste.tecnico.sasdesafio.model.Questao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/questoes"})
public class RecursoQuestao {

    private ServicoQuestao servicoQuestao;

    RecursoQuestao(ServicoQuestao servicoQuestao) {
        this.servicoQuestao = servicoQuestao;
    }

    @GetMapping
    public List<Questao> listar(){
        return servicoQuestao.listarQuestaos();
    }

    @PostMapping
    public Questao salvar(@Valid @RequestBody Questao questao){
        return servicoQuestao.salvarQuestao(questao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questao> atualizar(@PathVariable Integer id,
                                           @Valid @RequestBody Questao questao) {
        return ResponseEntity.ok(servicoQuestao.atualizarQuestao(id, questao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoQuestao.buscarQuestaoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Integer id) {
        servicoQuestao.removerQuestaoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
