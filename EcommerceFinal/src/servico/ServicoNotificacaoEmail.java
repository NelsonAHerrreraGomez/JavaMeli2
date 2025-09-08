package servico;

import dominio.Cliente;

public class ServicoNotificacaoEmail implements IServicoNotificacao {
    public void notificar(Cliente cliente, String mensagem) {
        System.out.println("📧 E-mail para " + cliente.getNome() + ": " + mensagem);
    }
}
