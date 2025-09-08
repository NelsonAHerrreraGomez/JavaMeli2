package pedido;

import cliente.Cliente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private LocalDateTime dataCriacao;
    private List<ItemPedido> itens = new ArrayList<>();
    private boolean finalizado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.dataCriacao = LocalDateTime.now();
        this.finalizado = false;
    }

    public void adicionarItem(ItemPedido item) {
        if (finalizado) throw new IllegalStateException("Pedido já finalizado!");
        itens.add(item);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::calcularTotal).sum();
    }

    public void finalizar() {
        if (itens.isEmpty()) throw new IllegalStateException("Pedido sem itens!");
        this.finalizado = true;
    }

    public boolean isFinalizado() { return finalizado; }
    public Cliente getCliente() { return cliente; }
}
