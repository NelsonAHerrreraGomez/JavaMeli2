package repositorio;

import dominio.Produto;
import java.util.UUID;
import java.util.List;

public interface IRepositorioProduto {
    void salvar(Produto produto);
    Produto buscarPorId(UUID id);
    List<Produto> listar();
}
