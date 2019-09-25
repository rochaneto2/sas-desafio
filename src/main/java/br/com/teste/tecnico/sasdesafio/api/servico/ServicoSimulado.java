package br.com.teste.tecnico.sasdesafio.api.servico;

import br.com.teste.tecnico.sasdesafio.api.repositorio.RepositorioSimulado;
import br.com.teste.tecnico.sasdesafio.model.Simulado;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

import static io.vavr.control.Option.ofOptional;

@Service
public class ServicoSimulado {
    
    private RepositorioSimulado repositorioSimulado;

    ServicoSimulado(RepositorioSimulado repositorioSimulado) {
        this.repositorioSimulado = repositorioSimulado;
    }

    public List<Simulado> listarSimulados(){
        return repositorioSimulado.findAll();
    }

    public Simulado buscarSimuladoPorId(Integer id){
        return ofOptional(repositorioSimulado.findById(id)).getOrElseThrow(() -> {
            throw new NoResultException("Não existe um Simulado com o ID especificado!");
        });
    }

    @Transactional
    public Simulado salvarSimulado(Simulado Simulado){
        return repositorioSimulado.saveAndFlush(Simulado);
    }

    @Transactional
    public Simulado atualizarSimulado(Integer id, Simulado Simulado){
        Simulado existente = buscarSimuladoPorId(id);

        BeanUtils.copyProperties(Simulado, existente, "id");

        salvarSimulado(existente);

        return existente;
    }

    public void removerSimuladoPorId(Integer id){
        repositorioSimulado.delete(buscarSimuladoPorId(id));
    }
}
