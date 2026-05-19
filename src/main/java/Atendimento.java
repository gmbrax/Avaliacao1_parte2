import java.time.LocalDateTime;

public class Atendimento {
    private AtendimentoEstado estado;
    private LocalDateTime dataAgendamento;
    private Tutor tutor;
    private Animal animal;
    public Atendimento() {
        this.estado = AtendimentoEstadoAgendado.getInstance();
    }
    public void setEstado(AtendimentoEstado estado){
        this.estado = estado;
    }

    public boolean agendar(){
        return estado.agendar(this);
    }
    public boolean continuar(){
        return estado.continuar(this);
    }
    public boolean cancelar(){
        return estado.cancelar(this);
    }
    public boolean finalizar(){
        return estado.finalizar(this);
    }
}
