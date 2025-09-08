import cliente.Cliente;
import produto.Produto;
import pedido.Pedido;
import pedido.ItemPedido;

public class Aplicacao {
    public static void main(String[] args) {
        // Criar cliente
        Cliente cliente = new Cliente("Nelson Herrera Gomez", "V5026242");

        // Criar produtos
        Produto notebook = new Produto("Notebook", 3500.0);
        Produto mouse = new Produto("Mouse", 150.0);

        // Criar pedido
        Pedido pedido = new Pedido(cliente);

        // Adicionar itens
        pedido.adicionarItem(new ItemPedido(notebook, 1, 3400.0));
        pedido.adicionarItem(new ItemPedido(mouse, 2, 120.0));

        // Finalizar pedido
        pedido.finalizar();

        // Mostrar resultado
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Documento Estrangeiro Residente : " + cliente.getDocumento());
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
        System.out.println("Pedido finalizado? " + pedido.isFinalizado());
    }
}
