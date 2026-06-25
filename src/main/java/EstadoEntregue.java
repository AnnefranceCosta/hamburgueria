public class EstadoEntregue implements PedidoEstado{
    @Override
    public void avancar(Pedido pedido) {
        throw new IllegalStateException("O pedido já foi entregue.");
    }
    @Override
    public String getDescricao() {
        return "Entregue";
    }
}
