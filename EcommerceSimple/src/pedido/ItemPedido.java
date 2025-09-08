package pedido;

import produto.Produto;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double preco; // preço de venda (pode ser diferente do catálogo)

    public ItemPedido(Produto produto, int quantidade, double preco) {
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade inválida!");
        if (preco <= 0) throw new IllegalArgumentException("Preço inválido!");
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public double calcularTotal() {
        return preco * quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public double getPreco() { return preco; }
}
