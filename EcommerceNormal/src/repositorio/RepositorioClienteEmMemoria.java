package repositorio;

import dominio.Cliente;
import java.util.*;

public class RepositorioClienteEmMemoria implements IRepositorioCliente {
    private Map<UUID, Cliente> clientes = new HashMap<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    @Override
    public Cliente buscarPorId(UUID id) {
        return clientes.get(id);
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes.values());
    }
}
