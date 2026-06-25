public class EstadoSaiuParaEntrega implements PedidoEstado{
    @Override
    public void avancar(Pedido pedido) {
        pedido.setEstado(new EstadoEntregue());
    }
    @Override
    public String getDescricao() {
        return "Saiu para entrega";
    }
}
