import java.util.Observable;
import java.util.Observer;

public class Secretaria implements Observer {
    private String ultimaNotificacao;


    @Override
    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = " teve uma atualização atendimento " + o.toString();

    }
}
