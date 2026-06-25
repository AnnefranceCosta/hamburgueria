public class NotificacaoCliente implements OuvinteStatus {
    private String ultimaMensagem;

    @Override
    public void atualizar(String novoStatus) {
        this.ultimaMensagem = "ZAP! Seu pedido mudou para: " + novoStatus;
    }

    public String getUltimaMensagem() {
        return this.ultimaMensagem;
    }
}
