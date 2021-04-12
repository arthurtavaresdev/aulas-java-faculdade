/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.dominio;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caioa
 */
public class PedidoTest {
    
    public PedidoTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
     // 5 - Criar testes para validar o método obterTotal()
    //Cenário de Sucesso conforme a regra onde o total é igual
    //a soma do preço dos itens do pedido, somando o frete mais o icms.
    
    @Test
    public void testValidarObterTotalIgualASomaDosItens() {
        Produto p1 = new Produto();
        p1.setNome("Teclado");
        p1.setPreco(500.0);
        
        Cliente c = new Cliente();
        c.setNome("Caio");

        Pedido p = new PedidoBuilder().addProduto(p1, 2)
                .setCliente(c)
                .setEnderecoEntrega(new Endereco(
                        "MG", "Contagem", "Europa", "32.155-054", "Rua teste", "1987"
                )).getResultado();
        
        Double totalPedido = p.obterTotal();
        double totalItens = p.getItens().stream()
                .map(item -> item.obterTotal() * p.getCalculoICMS().getImposto() + p.getCalculoFrete().getFrete())
                .reduce((a, b) -> a + b).orElse(0.0);
        Assert.assertEquals(totalPedido, totalItens);
        
    }
    
}
