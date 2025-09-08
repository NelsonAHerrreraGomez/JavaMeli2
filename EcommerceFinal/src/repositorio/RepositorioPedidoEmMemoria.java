package repositorio;

import dominio.Pedido;
import java.util.*;

public class RepositorioPedidoEmMemoria implements IRepositorioPedido {
    private Map<UUID, Pedido> pedidos = new HashMap<>();
    public void salvar(Pedido pedido) { pedidos.put(pedido.getId(), pedido); }
    public Pedido buscarPorId(UUID id) { return pedidos.get(id); }
    public List<Pedido> listar() { return new ArrayList<>(pedidos.values()); }
}
