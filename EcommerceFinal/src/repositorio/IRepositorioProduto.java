package repositorio;

import dominio.Produto;
import java.util.List;
import java.util.UUID;

public interface IRepositorioProduto {
    void salvar(Produto produto);
    Produto buscarPorId(UUID id);
    List<Produto> listar();
}
