package br.com.teste.tecnico.sasdesafio.api.recurso;

import br.com.teste.tecnico.sasdesafio.api.servico.ServicoSimulado;
import br.com.teste.tecnico.sasdesafio.model.Simulado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/simulados"})
public class RecursoSimulado {

    private ServicoSimulado servicoSimulado;

    RecursoSimulado(ServicoSimulado servicoSimulado) {
        this.servicoSimulado = servicoSimulado;
    }

    @GetMapping
    public List<Simulado> listar(){
        return servicoSimulado.listarSimulados();
    }

    @PostMapping
    public Simulado salvar(@Valid @RequestBody Simulado simulado){
        return servicoSimulado.salvarSimulado(simulado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Simulado> atualizar(@PathVariable Integer id,
                                           @Valid @RequestBody Simulado simulado) {
        return ResponseEntity.ok(servicoSimulado.atualizarSimulado(id, simulado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Simulado> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoSimulado.buscarSimuladoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Integer id) {
        servicoSimulado.removerSimuladoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
