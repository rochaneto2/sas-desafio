package br.com.teste.tecnico.sasdesafio.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public abstract class EntidadeBase<I extends Number> implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private I id;

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EntidadeBase<I> that = (EntidadeBase<I>) o;

        return Objects.equals(id, that.id);
    }
}
