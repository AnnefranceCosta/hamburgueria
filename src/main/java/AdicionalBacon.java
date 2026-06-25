public class AdicionalBacon extends AdicionalDecorator{
    public AdicionalBacon(Item lanche) {
        super(lanche);
    }

    @Override
    public float getPreco() {
        return lanche.getPreco() + 5.00f;
    }

    @Override
    public String getDescricao() {
        return lanche.getDescricao() + " + Bacon";
    }
}
