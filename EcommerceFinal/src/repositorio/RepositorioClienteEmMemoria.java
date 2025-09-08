package repositorio;

import dominio.Cliente;
import java.util.*;

public class RepositorioClienteEmMemoria implements IRepositorioCliente {
    private Map<UUID, Cliente> clientes = new HashMap<>();
    public void salvar(Cliente cliente) { clientes.put(cliente.getId(), cliente); }
    public Cliente buscarPorId(UUID id) { return clientes.get(id); }
    public List<Cliente> listar() { return new ArrayList<>(clientes.values()); }
}
