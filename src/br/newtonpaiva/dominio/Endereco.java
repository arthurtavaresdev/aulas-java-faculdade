package br.newtonpaiva.dominio;

import br.newtonpaiva.PersistenceService;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String uf;
    private String cidade;
    private String bairro;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    
    @ManyToOne
    private Cliente cliente;
    
    public Endereco() {
    }

    public Endereco(String uf, String cidade, String bairro, String cep, String logradouro, String numero, String complemento, Cliente cliente) {
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cliente = cliente;
    }
    
    public Endereco(String uf, String cidade, String bairro, String cep, String logradouro, String numero, Cliente cliente) {
        this(uf, cidade, bairro, cep, logradouro, numero, null, cliente);
    }

    public Endereco(String uf, String cidade, String bairro, String cep, String logradouro, String numero) {
        this(uf, cidade, bairro, cep, logradouro, numero, null, null);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
