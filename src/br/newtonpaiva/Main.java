package br.newtonpaiva;

import java.io.IOException;

import br.newtonpaiva.dominio.*;
import br.newtonpaiva.dominio.geradorArquivo.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class Main {
    public static void main(String[] args) {
        EntityManager em = PersistenceService.getEntityManager();
        
        em.getTransaction().begin();
        
        Categoria c1 = new Categoria();
        c1.setNome("Jogos");
        em.persist(c1);
   
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        
        Categoria c2 = new Categoria();
        c2.setNome("SmartTV");
        em.persist(c1);
   
        em.getTransaction().commit();
        
        
        Produto p1 = new Produto();
        p1.setNome("Mouse com fio");
        p1.setEstoque(10);
        p1.setPreco(143.99);

        Produto p2 = new Produto();
        p2.setNome("Notebook Dell Maneiro");
        p1.setEstoque(20);
        p2.setPreco(3543.99);
                                           


        c1.getProdutos().add(p1);
        c1.getProdutos().add(p2);
        
        Cliente c = new Cliente();
        c.setNome("Tarley");
        Pedido p = new PedidoBuilder()
                .addProduto(p1, 2)
                .addProduto(p2, 1)
                .setCliente(c)
                .setEnderecoEntrega(new Endereco(
                        "MG", "Contagem", "Cabral", "32.155-054", "Rua dos bobos", "1987"
                ))
                .getResultado();
        
        em.close();
      
        try {
            GeradorArquivo file = new GeradorArquivoXML();
            file.gerar("exemplo.xml", p);

            file = new GeradorArquivoJson();
            file.gerar("exemplo.json", p);

            file = new GeradorArquivoXMLCripto();
            file.gerar("teste.xml.cripto", p);

            file = new GeradorArquivoXMLCompactado();
            file.gerar("exemplo.zip", p);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}

