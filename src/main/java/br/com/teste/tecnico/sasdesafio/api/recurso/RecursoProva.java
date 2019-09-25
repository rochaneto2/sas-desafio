package br.com.teste.tecnico.sasdesafio.api.recurso;

import br.com.teste.tecnico.sasdesafio.api.servico.ServicoProva;
import br.com.teste.tecnico.sasdesafio.model.Prova;
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
    public List<Prova> listar(){
        return servicoProva.listarProvas();
    }

    @PostMapping
    public Prova salvar(@Valid @RequestBody Prova Prova){
        return servicoProva.salvarProva(Prova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prova> atualizar(@PathVariable Integer id,
                                           @Valid @RequestBody Prova Prova) {
        return ResponseEntity.ok(servicoProva.atualizarProva(id, Prova));
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
}
