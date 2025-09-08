package repositorio;

import dominio.Cliente;
import java.util.UUID;
import java.util.List;

public interface IRepositorioCliente {
    void salvar(Cliente cliente);
    Cliente buscarPorId(UUID id);
    List<Cliente> listar();
}
