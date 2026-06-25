import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private PedidoEstado estadoAtual = new EstadoPreparando();
    private List<OuvinteStatus> ouvintes = new ArrayList<>();

    public void adicionarOuvinte(OuvinteStatus ouvinte) { this.ouvintes.add(ouvinte); }

    private void notificarOuvintes() {
        for (OuvinteStatus ouvinte : ouvintes) {
            ouvinte.atualizar(estadoAtual.getDescricao());
        }
    }

    public void setEstado(PedidoEstado novoEstado) {
        this.estadoAtual = novoEstado;
        notificarOuvintes();
    }

    public void avancarEtapa() {
        estadoAtual.avancar(this);
    }

    public String getStatus() {
        return estadoAtual.getDescricao();
    }
}
