package aplicacao;

import dominio.*;
import repositorio.*;
import servico.*;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        IRepositorioCliente repoCliente = new RepositorioClienteEmMemoria();
        IRepositorioProduto repoProduto = new RepositorioProdutoEmMemoria();
        IRepositorioPedido repoPedido = new RepositorioPedidoEmMemoria();
        IServicoNotificacao notificacao = new ServicoNotificacaoEmail();
        ValidacaoPedido validacao = new ValidacaoPedido();

        ServicoPedido servicoPedido = new ServicoPedido(repoCliente, repoProduto, repoPedido, notificacao, validacao);

        Cliente cliente = new Cliente("Nelson Herrera");
        Produto produto = new Produto("Notebook", 3500);

        repoCliente.salvar(cliente);
        repoProduto.salvar(produto);

        Pedido pedido = servicoPedido.criarPedido(cliente.getId());
        servicoPedido.adicionarItem(pedido.getId(), produto.getId(), 1);
        servicoPedido.finalizarPedido(pedido.getId());
    }
}
