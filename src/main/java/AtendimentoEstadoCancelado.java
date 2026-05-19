public class AtendimentoEstadoCancelado extends AtendimentoEstado{

    private static AtendimentoEstadoCancelado instance = null;
    private AtendimentoEstadoCancelado(){}
    public static AtendimentoEstadoCancelado getInstance(){
        if(instance == null){
            instance = new AtendimentoEstadoCancelado();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        setChanged();
        notifyObservers();
        return "Cancelado";
    }
}
