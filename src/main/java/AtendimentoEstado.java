import java.util.Observable;

public abstract class AtendimentoEstado extends Observable {



    public  abstract String getEstado();

    public boolean finalizar(Atendimento atendimento){
        return false;
    }
    public boolean agendar(Atendimento atendimento){
        return false;
    }
    public boolean continuar(Atendimento atendimento){
        return false;
    }
    public boolean cancelar(Atendimento atendimento){
        return false;
    }


    @Override
    public String toString() {
        return this.getEstado();
    }
}
