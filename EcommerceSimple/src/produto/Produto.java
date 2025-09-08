package produto;

import java.util.UUID;

public class Produto {
    private UUID id;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório!");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero!");
        }
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.preco = preco;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }

    public void atualizarPreco(double novoPreco) {
        if (novoPreco <= 0) throw new IllegalArgumentException("Preço inválido!");
        this.preco = novoPreco;
    }
}
