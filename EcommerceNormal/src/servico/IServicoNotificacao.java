package servico;

import dominio.Cliente;

public interface IServicoNotificacao {
    void notificar(Cliente cliente, String mensagem);
}
