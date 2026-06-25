public class AdicionalQueijo extends AdicionalDecorator{
    public AdicionalQueijo(Item lanche) {
        super(lanche);
    }

    @Override
    public float getPreco() {
        return lanche.getPreco() + 4.00f;
    }

    @Override
    public String getDescricao() {
        return lanche.getDescricao() + " + Queijo";
    }
}
