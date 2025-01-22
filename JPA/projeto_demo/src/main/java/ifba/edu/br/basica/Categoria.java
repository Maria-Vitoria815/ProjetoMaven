package ifba.edu.br.basica;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Cliente> cliente;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Categoria() {
    }
    public Categoria(String descricao) {
        super();
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return "Categoria [id=" + id + ", descricao=" + descricao + "]";
    }


}
