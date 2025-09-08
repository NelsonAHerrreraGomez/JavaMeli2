package servico;

import dominio.Cliente;

public class ServicoNotificacaoEmail implements IServicoNotificacao {
    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.println("📧 Enviando e-mail para " + cliente.getNome() + ": " + mensagem);
    }
}
