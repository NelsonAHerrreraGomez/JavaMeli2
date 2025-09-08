package dominio;

import java.time.LocalDateTime;
import java.util.*;

public class Pedido {
    private UUID id;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private String status;          // ABERTO, FINALIZADO
    private String statusPagamento; // AGUARDANDO, PAGO
    private LocalDateTime dataCriacao;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.status = "ABERTO";
        this.dataCriacao = LocalDateTime.now();
    }

    public void adicionarItem(ItemPedido item) {
        if (!status.equals("ABERTO")) {
            throw new IllegalStateException("Pedido não pode receber itens, não está ABERTO.");
        }
        itens.add(item);
    }

    public void finalizar() {
        if (itens.isEmpty() || calcularTotal() <= 0) {
            throw new IllegalStateException("Pedido inválido para finalização.");
        }
        this.statusPagamento = "AGUARDANDO PAGAMENTO";
    }

    public void pagar() {
        if (!"AGUARDANDO PAGAMENTO".equals(statusPagamento)) {
            throw new IllegalStateException("Pagamento não permitido.");
        }
        this.statusPagamento = "PAGO";
    }

    public void entregar() {
        if (!"PAGO".equals(statusPagamento)) {
            throw new IllegalStateException("Entrega só pode ser feita após pagamento.");
        }
        this.status = "FINALIZADO";
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::calcularTotal).sum();
    }

    // getters
    public UUID getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }
    public String getStatus() { return status; }
    public String getStatusPagamento() { return statusPagamento; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
}
