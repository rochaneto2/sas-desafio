package br.com.teste.tecnico.sasdesafio.api.servico;

import br.com.teste.tecnico.sasdesafio.api.repositorio.RepositorioProva;
import br.com.teste.tecnico.sasdesafio.model.Prova;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

import static io.vavr.control.Option.ofOptional;

@Service
public class ServicoProva {
    
    private RepositorioProva repositorioProva;

    ServicoProva(RepositorioProva repositorioProva) {
        this.repositorioProva = repositorioProva;
    }

    public List<Prova> listarProvas(){
        return repositorioProva.findAll();
    }

    public Prova buscarProvaPorId(Integer id){
        return ofOptional(repositorioProva.findById(id)).getOrElseThrow(() -> {
            throw new NoResultException("Não existe uma Prova com o ID especificado!");
        });
    }

    @Transactional
    public Prova salvarProva(Prova Prova){
        return repositorioProva.saveAndFlush(Prova);
    }

    @Transactional
    public Prova atualizarProva(Integer id, Prova Prova){
        Prova existente = buscarProvaPorId(id);

        BeanUtils.copyProperties(Prova, existente, "id");

        salvarProva(existente);

        return existente;
    }

    public void removerProvaPorId(Integer id){
        repositorioProva.delete(buscarProvaPorId(id));
    }
}
