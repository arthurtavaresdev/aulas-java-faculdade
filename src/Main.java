import br.newton.dominio.*;
import br.newton.dominio.frete.*;
import br.newton.dominio.icms.IcmsES;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cliente c = new Cliente();
        c.setNome("Arthur");

        Produto p1 = new Produto();
        p1.setNome("Teclado com fio");
        p1.setPreco(123.99);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPreco(p1.getPreco());
        itemPedido.setQuantidade(2);
        itemPedido.setProduto(p1);


        Pedido p = new Pedido(100);
        p.setCalculoFrete(new FreteES());
        p.setCalculoICMS(new IcmsES());
        p.getItens().add(itemPedido);
        p.setCliente(c);


        System.out.println("Valor total do pedido = " + p.obterTotal());
    }
}