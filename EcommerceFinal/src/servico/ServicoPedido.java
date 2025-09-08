package servico;

import dominio.*;
import repositorio.*;
import java.util.UUID;

public class ServicoPedido {
    private IRepositorioCliente repoCliente;
    private IRepositorioProduto repoProduto;
    private IRepositorioPedido repoPedido;
    private IServicoNotificacao notificacao;
    private ValidacaoPedido validacao;

    public ServicoPedido(IRepositorioCliente repoCliente,
                         IRepositorioProduto repoProduto,
                         IRepositorioPedido repoPedido,
                         IServicoNotificacao notificacao,
                         ValidacaoPedido validacao) {
        this.repoCliente = repoCliente;
        this.repoProduto = repoProduto;
        this.repoPedido = repoPedido;
        this.notificacao = notificacao;
        this.validacao = validacao;
    }

    public Pedido criarPedido(UUID clienteId) {
        Cliente cliente = repoCliente.buscarPorId(clienteId);
        Pedido pedido = new Pedido(cliente);
        repoPedido.salvar(pedido);
        return pedido;
    }

    public void adicionarItem(UUID pedidoId, UUID produtoId, int quantidade) {
        Pedido pedido = repoPedido.buscarPorId(pedidoId);
        Produto produto = repoProduto.buscarPorId(produtoId);
        pedido.adicionarItem(new ItemPedido(produto, quantidade, produto.getPreco()));
    }

    public void finalizarPedido(UUID pedidoId) {
        Pedido pedido = repoPedido.buscarPorId(pedidoId);
        if (validacao.validar(pedido)) {
            pedido.finalizar();
            notificacao.notificar(pedido.getCliente(),
                    "Pedido finalizado! Valor: R$ " + pedido.calcularTotal());
        } else {
            System.out.println("❌ Pedido inválido para finalização.");
        }
    }

    public void realizarPagamento(UUID pedidoId) {
        Pedido pedido = repoPedido.buscarPorId(pedidoId);
        pedido.pagar();
        notificacao.notificar(pedido.getCliente(),
                "Pagamento confirmado do pedido " + pedido.getId());
    }

    public void entregarPedido(UUID pedidoId) {
        Pedido pedido = repoPedido.buscarPorId(pedidoId);
        pedido.entregar();
        notificacao.notificar(pedido.getCliente(),
                "Pedido entregue! Obrigado pela compra.");
    }
}
