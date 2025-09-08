package aplicacao;

import dominio.*;
import repositorio.*;
import servico.*;

public class Main {
    public static void main(String[] args) {
        IRepositorioCliente repoCliente = new RepositorioClienteEmMemoria();
        IRepositorioProduto repoProduto = new RepositorioProdutoEmMemoria();
        IRepositorioPedido repoPedido = new RepositorioPedidoEmMemoria();
        IServicoNotificacao notificacao = new ServicoNotificacaoEmail();
        ValidacaoPedido validacao = new ValidacaoPedido();

        ServicoPedido servicoPedido = new ServicoPedido(
                repoCliente, repoProduto, repoPedido, notificacao, validacao);

        // 1️⃣ Criar cliente e produto
        Cliente cliente = new Cliente("Carlos", "123.456.789-00");
        Produto produto = new Produto("Notebook", 3500);
        repoCliente.salvar(cliente);
        repoProduto.salvar(produto);

        // 2️⃣ Criar pedido
        Pedido pedido = servicoPedido.criarPedido(cliente.getId());
        System.out.println("✅ Pedido criado com ID: " + pedido.getId() +
                " | Status: " + pedido.getStatus() +
                " | Data: " + pedido.getDataCriacao());

// 3️⃣ Adicionar item
        servicoPedido.adicionarItem(pedido.getId(), produto.getId(), 1);
        System.out.println("🛒 Produto adicionado: " + produto.getNome() +
                " | Quantidade: 1 | Total pedido: R$ " + pedido.calcularTotal());

// 4️⃣ Finalizar pedido
        servicoPedido.finalizarPedido(pedido.getId());
        System.out.println("📌 Status do pagamento: " + pedido.getStatusPagamento());

// 5️⃣ Realizar pagamento
        servicoPedido.realizarPagamento(pedido.getId());
        System.out.println("💳 Pagamento realizado. Status pagamento: " + pedido.getStatusPagamento());

// 6️⃣ Entregar pedido
        servicoPedido.entregarPedido(pedido.getId());
        System.out.println("📦 Pedido entregue. Status final: " + pedido.getStatus());

    }
}
