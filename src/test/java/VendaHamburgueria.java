import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VendaHamburgueria {
    @Test
    public void deveCalcularTotalComFreteFixoParaEntrega() {
        CardapioFactory cardapio = CardapioFactory.getInstancia();
        List<Item> carrinho = new ArrayList<>();
        carrinho.add(cardapio.criarLanche("Bovino"));
        carrinho.add(new AdicionalBacon(cardapio.criarLanche("Vegano")));

        CheckoutFacade checkout = new CheckoutFacade(new FreteFixo());

        float totalFinal = checkout.finalizarCompra(carrinho, 5.0f);
        assertEquals(64.00f, totalFinal, 0.01f);
    }

    @Test
    public void deveCalcularTotalSemFreteParaRetiradaNoBalcao() {
        CardapioFactory cardapio = CardapioFactory.getInstancia();
        List<Item> carrinho = new ArrayList<>();
        carrinho.add(cardapio.criarLanche("Bovino"));

        CheckoutFacade checkout = new CheckoutFacade(new RetiradaBalcao());

        float totalFinal = checkout.finalizarCompra(carrinho, 0.0f);
        assertEquals(25.00f, totalFinal, 0.01f);
    }
}
