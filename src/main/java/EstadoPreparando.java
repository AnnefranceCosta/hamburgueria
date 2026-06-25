public class EstadoPreparando implements PedidoEstado{
    @Override
    public void avancar(Pedido pedido) {
        pedido.setEstado(new EstadoSaiuParaEntrega());
    }
    @Override
    public String getDescricao() { return "Preparando lanche"; }
}
