package br.newtonpaiva.dominio;

import br.newtonpaiva.PersistenceService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String nome;
    private String telefone;
    private String email;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();
    
    public Cliente() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Double obterTotal(){
        return 0.0;
    }
    
    public Cliente save() throws Exception {
        PersistenceService.getEntityManager().persist(this);
        return this;
    }
    
    public static List<Cliente> findAllByUf(String uf) {
        String query = "SELECT DISTINCT cliente "
                + "FROM Cliente cliente "
                + "INNER JOIN Endereco endereco on (cliente.id = endereco.cliente.id) "
                + "WHERE endereco.uf LIKE :uf";
        return PersistenceService.getEntityManager().createQuery(query, Cliente.class)
                .setParameter("uf", uf).getResultList();
    }
}
