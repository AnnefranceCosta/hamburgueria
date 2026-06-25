public abstract class AdicionalDecorator implements Item{
    protected Item lanche;

    public AdicionalDecorator(Item lanche) { this.lanche = lanche; }

    @Override
    public Item clonar() {
        try {
            AdicionalDecorator clone = (AdicionalDecorator) super.clone();
            clone.lanche = this.lanche.clonar();
            return clone;
        } catch (CloneNotSupportedException e) { return null; }
    }
}
