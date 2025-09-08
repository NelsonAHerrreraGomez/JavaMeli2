package repositorio;

import dominio.Pedido;
import java.util.UUID;
import java.util.List;

public interface IRepositorioPedido {
    void salvar(Pedido pedido);
    Pedido buscarPorId(UUID id);
    List<Pedido> listar();
}
