public abstract class AtendimentoEstado {



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
}
