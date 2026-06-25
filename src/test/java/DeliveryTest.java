import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeliveryTest {
    @Test
    public void deveMudarDeEstadoENotificarClienteAutomaticamente() {
        Pedido pedido = new Pedido();
        NotificacaoCliente telaCelular = new NotificacaoCliente();
        pedido.adicionarOuvinte(telaCelular);

        assertEquals("Preparando lanche", pedido.getStatus());

        pedido.avancarEtapa();
        assertEquals("Saiu para entrega", pedido.getStatus());
        assertEquals("ZAP! Seu pedido mudou para: Saiu para entrega", telaCelular.getUltimaMensagem());

        pedido.avancarEtapa();
        assertEquals("Entregue", pedido.getStatus());
        assertEquals("ZAP! Seu pedido mudou para: Entregue", telaCelular.getUltimaMensagem());
    }

    @Test(expected = IllegalStateException.class)
    public void deveBloquearAvancoAposPedidoEntregue() {
        Pedido pedido = new Pedido();
        pedido.avancarEtapa();
        pedido.avancarEtapa();

        pedido.avancarEtapa();
    }
}
