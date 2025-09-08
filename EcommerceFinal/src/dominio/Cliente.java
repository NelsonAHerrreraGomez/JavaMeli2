package dominio;

import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nome;
    private String documento;

    public Cliente(String nome, String documento) {
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Documento é obrigatório.");
        }
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.documento = documento;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getDocumento() { return documento; }
}
