package repositorio;

import dominio.Pedido;
import java.util.*;

public class RepositorioPedidoEmMemoria implements IRepositorioPedido {
    private Map<UUID, Pedido> pedidos = new HashMap<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    @Override
    public Pedido buscarPorId(UUID id) {
        return pedidos.get(id);
    }

    @Override
    public List<Pedido> listar() {
        return new ArrayList<>(pedidos.values());
    }
}
