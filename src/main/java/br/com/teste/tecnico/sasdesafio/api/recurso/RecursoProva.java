package br.com.teste.tecnico.sasdesafio.api.recurso;

import br.com.teste.tecnico.sasdesafio.api.servico.ServicoProva;
import br.com.teste.tecnico.sasdesafio.model.Prova;
import br.com.teste.tecnico.sasdesafio.model.classesVO.GabaritoVO;
import br.com.teste.tecnico.sasdesafio.model.classesVO.PostResponderQuestaoVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/provas"})
public class RecursoProva {

    private ServicoProva servicoProva;

    RecursoProva(ServicoProva servicoProva) {
        this.servicoProva = servicoProva;
    }

    @GetMapping
    public List<Prova> listar() {
        return servicoProva.listarProvas();
    }

    @PostMapping
    public Prova salvar(@Valid @RequestBody Prova prova) {
        return servicoProva.salvarProva(prova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prova> atualizar(@PathVariable Integer id,
                                           @Valid @RequestBody Prova prova) {
        return ResponseEntity.ok(servicoProva.atualizarProva(id, prova));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prova> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoProva.buscarProvaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Integer id) {
        servicoProva.removerProvaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/gabarito")
    public ResponseEntity<List<GabaritoVO>> buscarGabaritoPorProva(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoProva.buscarGabaritoPorProva(id));
    }

    @PostMapping("/resolver-prova")
    public String resolverProva(@Valid @RequestBody List<PostResponderQuestaoVO> questoes) {
        return servicoProva.resolverProva(questoes);
    }
}
