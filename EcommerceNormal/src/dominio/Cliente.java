package dominio;

import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nome;

    public Cliente(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
