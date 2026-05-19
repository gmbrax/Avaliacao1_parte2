import java.util.Observable;
import java.util.Observer;

public class Veterinario implements Observer {

    private String nome;
    private String telefone;
    private String email;
    private String CPF;
    private String matricula;

    private String ultimaNotificacao;

    @Override
    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = "teve uma atualização atendimento " + o.toString();

    }
}
