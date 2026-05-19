public class AtendimentoEstadoAgendado extends AtendimentoEstado{


    private static  AtendimentoEstadoAgendado instance = null;

    private AtendimentoEstadoAgendado(){}

    public static  AtendimentoEstadoAgendado getInstance(){
        if(instance == null){
            instance = new AtendimentoEstadoAgendado();
        }
        return instance;
    }

    @Override
    public boolean cancelar(Atendimento atendimento){
        atendimento.setEstado(AtendimentoEstadoCancelado.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Agendado";
    }

    @Override
    public boolean continuar(Atendimento atendimento){
        atendimento.setEstado(AtendimentoEstadoEmAndamento.getInstance());
        return true;
    }
}
