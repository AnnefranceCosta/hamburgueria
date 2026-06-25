import java.util.List;

public class CheckoutFacade {
    private CalculoFrete estrategiaFrete;

    public CheckoutFacade(CalculoFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public float finalizarCompra(List<Item> carrinho, float distanciaKm) {
        float totalItens = 0;
        for (Item item : carrinho) {
            totalItens += item.getPreco();
        }
        float valorFrete = estrategiaFrete.calcular(distanciaKm);
        return totalItens + valorFrete;
    }
}
