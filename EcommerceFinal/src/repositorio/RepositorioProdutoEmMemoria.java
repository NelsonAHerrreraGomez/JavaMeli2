package repositorio;

import dominio.Produto;
import java.util.*;

public class RepositorioProdutoEmMemoria implements IRepositorioProduto {
    private Map<UUID, Produto> produtos = new HashMap<>();
    public void salvar(Produto produto) { produtos.put(produto.getId(), produto); }
    public Produto buscarPorId(UUID id) { return produtos.get(id); }
    public List<Produto> listar() { return new ArrayList<>(produtos.values()); }
}
