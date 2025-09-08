package servico;

import dominio.Pedido;

public class ValidacaoPedido {
    public boolean validar(Pedido pedido) {
        return !pedido.getItens().isEmpty() && pedido.calcularTotal() > 0;
    }
}
