public class AtendimentoEstadoEmAndamento extends AtendimentoEstado{


    private static  AtendimentoEstadoEmAndamento instance = null;

    private AtendimentoEstadoEmAndamento(){}

    public static AtendimentoEstadoEmAndamento getInstance(){
        if(instance == null){
            instance = new AtendimentoEstadoEmAndamento();
        }
        return instance;
    }

    @Override
    public String getEstado() {

        return "Em Andamento";
    }

    @Override
    public boolean finalizar(Atendimento atendimento){
        setChanged();
        notifyObservers();
        atendimento.setEstado(AtendimentoEstadoFinalizado.getInstance());
        return true;
    }


}
