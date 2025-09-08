package repositorio;

import dominio.Pedido;
import java.util.List;
import java.util.UUID;

public interface IRepositorioPedido {
    void salvar(Pedido pedido);
    Pedido buscarPorId(UUID id);
    List<Pedido> listar();
}
