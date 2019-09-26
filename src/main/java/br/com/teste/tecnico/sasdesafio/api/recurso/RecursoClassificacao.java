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

    private ServicoClassificacao ServicoClassificacao;

    RecursoClassificacao(ServicoClassificacao ServicoClassificacao) {
        this.ServicoClassificacao = ServicoClassificacao;
    }

    @GetMapping
    public List<Classificacao> listar(){
        return ServicoClassificacao.listarClassificacaos();
    }

    @PostMapping
    public Classificacao salvar(@Valid @RequestBody Classificacao classificacao){
        return ServicoClassificacao.salvarClassificacao(classificacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classificacao> atualizar(@PathVariable Integer id,
                                           @Valid @RequestBody Classificacao classificacao) {
        return ResponseEntity.ok(ServicoClassificacao.atualizarClassificacao(id, classificacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classificacao> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(ServicoClassificacao.buscarClassificacaoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Integer id) {
        ServicoClassificacao.removerClassificacaoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
