import java.util.ArrayList;
import java.util.List;

public class CardapioFactory {
    private static CardapioFactory instancia;

    private CardapioFactory() {}

    public static synchronized CardapioFactory getInstancia() {
        if (instancia == null) {
            instancia = new CardapioFactory();
        }
        return instancia;
    }

    public Hamburguer criarLanche(String tipo) {
        if (tipo.equalsIgnoreCase("Bovino")) {
            return new Hamburguer("Brioche", "Bovino 180g", 25.00f);
        }
        if (tipo.equalsIgnoreCase("Vegano")) {
            return new Hamburguer("Australiano", "Grão-de-Bico", 27.00f);
        }
        throw new IllegalArgumentException("Lanche não disponível.");
    }

    public List<Item> criarComboCasal() {
        List<Item> combo = new ArrayList<>();
        combo.add(criarLanche("Bovino"));
        combo.add(criarLanche("Vegano"));
        return combo;
    }
}
