import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CardapioTestes {
    @Test
    public void deveCalcularPrecoDoLancheBase() {
        CardapioFactory cardapio = CardapioFactory.getInstancia();
        Item lanche = cardapio.criarLanche("Bovino");

        assertEquals(25.00f, lanche.getPreco(), 0.01f);
        assertEquals("Hambúrguer Bovino 180g no pão Brioche", lanche.getDescricao());
    }

    @Test
    public void deveCalcularPrecoComAdicionais() {
        CardapioFactory cardapio = CardapioFactory.getInstancia();
        Item lancheComBaconEQueijo = new AdicionalQueijo(new AdicionalBacon(cardapio.criarLanche("Vegano")));

        assertEquals(36.00f, lancheComBaconEQueijo.getPreco(), 0.01f);
        assertEquals("Hambúrguer Grão-de-Bico no pão Australiano + Bacon + Queijo", lancheComBaconEQueijo.getDescricao());
    }

    @Test
    public void deveDuplicarLancheCustomizadoParaPedidoRepetido() {
        CardapioFactory cardapio = CardapioFactory.getInstancia();
        Item lancheOriginal = new AdicionalBacon(cardapio.criarLanche("Bovino"));

        Item lancheClonado = lancheOriginal.clonar();

        assertNotSame(lancheOriginal, lancheClonado);
        assertEquals(lancheOriginal.getPreco(), lancheClonado.getPreco(), 0.01f);
        assertEquals(lancheOriginal.getDescricao(), lancheClonado.getDescricao());
    }

    @Test
    public void deveCriarItensDoComboCasal() {
        CardapioFactory cardapio = CardapioFactory.getInstancia();
        List<Item> combo = cardapio.criarComboCasal();

        assertEquals(2, combo.size());
        assertEquals("Hambúrguer Bovino 180g no pão Brioche", combo.get(0).getDescricao());
        assertEquals("Hambúrguer Grão-de-Bico no pão Australiano", combo.get(1).getDescricao());
    }
}
