package ifba.edu.br.basica;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cpf;
    private String rg;

    @ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
    private Categoria categoria;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String rg, Categoria categoria) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.categoria = categoria;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", categoria=" + categoria.getDescricao()
                + "]";
    }
    
}
