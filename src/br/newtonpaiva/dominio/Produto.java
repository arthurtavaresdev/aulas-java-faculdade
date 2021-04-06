package br.newtonpaiva.dominio;

import br.newtonpaiva.PersistenceService;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable  = false, unique = true)
    private String nome;
    
    private Double preco;
    private String descricao;
    private Categoria categoria;
    private Integer estoque;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setEstoque(Integer estoque){
        this.estoque = estoque;
    }
    
    public Integer getEstoque(){
        return this.estoque;
    }
    
    public void incrementarEstoque(){
        this.estoque++;
    }
    
    public void diminuirEstoque(){
        this.estoque--;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static List<Produto> findByNome(String nome) {
        return PersistenceService.getEntityManager().createQuery("SELECT produto FROM Produto produto WHERE produto.nome LIKE :nome", Produto.class)
                .setParameter("nome", nome).getResultList();
    }
    
    public Boolean validate(){
        List<Produto> produtos = findByNome(this.nome);
        return produtos.isEmpty();
    }
    
    public Produto save() throws Exception {
        if(!this.validate()){
            throw new Exception("Produto invalido");
        }
      
        PersistenceService.getEntityManager().persist(this);
        return this;
    }
}
