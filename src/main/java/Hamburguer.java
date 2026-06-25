public class Hamburguer implements Item{
    private String pao;
    private String blend;
    private float preco;

    public Hamburguer(String pao, String blend, float preco) {
        this.pao = pao;
        this.blend = blend;
        this.preco = preco;
    }

    @Override
    public float getPreco() {
        return this.preco;
    }

    @Override
    public String getDescricao() {
        return "Hambúrguer " + blend + " no pão " + pao;
    }

    @Override
    public Item clonar() {
        try {
            return (Hamburguer) super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null; }
    }
}
