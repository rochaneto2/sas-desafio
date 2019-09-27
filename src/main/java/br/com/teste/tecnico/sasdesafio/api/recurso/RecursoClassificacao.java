package br.com.teste.tecnico.sasdesafio.api.recurso;

import br.com.teste.tecnico.sasdesafio.api.servico.ServicoClassificacao;
import br.com.teste.tecnico.sasdesafio.model.Classificacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/classificacoes"})
public class RecursoClassificacao {

    private ServicoClassificacao servicoClassificacao;

    RecursoClassificacao(ServicoClassificacao servicoClassificacao) {
        this.servicoClassificacao = servicoClassificacao;
    }

    @GetMapping
    public List<Classificacao> listar() {
        return servicoClassificacao.listarClassificacaos();
    }

    @PostMapping
    public Classificacao salvar(@Valid @RequestBody Classificacao classificacao) {
        return servicoClassificacao.salvarClassificacao(classificacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classificacao> atualizar(@PathVariable Integer id,
                                                   @Valid @RequestBody Classificacao classificacao) {
        return ResponseEntity.ok(servicoClassificacao.atualizarClassificacao(id, classificacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classificacao> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoClassificacao.buscarClassificacaoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Integer id) {
        servicoClassificacao.removerClassificacaoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/simulado/{idSimulado}")
    public ResponseEntity buscarClassificacaoPorSimulado(@PathVariable Integer idSimulado,
                                                         @RequestParam Integer limite) {
        return ResponseEntity.ok(servicoClassificacao.buscarPorSimulado(idSimulado, limite));
    }
}
