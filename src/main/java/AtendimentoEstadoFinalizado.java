public class AtendimentoEstadoFinalizado extends AtendimentoEstado{

    private static AtendimentoEstadoFinalizado instance = null;

    private AtendimentoEstadoFinalizado(){}

    public static AtendimentoEstadoFinalizado getInstance(){
        if(instance == null){
            instance = new AtendimentoEstadoFinalizado();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Finalizado";
    }

}
