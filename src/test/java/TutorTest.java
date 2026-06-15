

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TutorTest {

    Tutor tutor;
    Atendimento atendimento;

    @BeforeEach
    public void setUp() {
        tutor = new Tutor();
        tutor.setNome("Carlos");
        atendimento = new Atendimento();
    }

    // Dados do tutor

    @Test
    public void deveCriarTutorComNome() {
        assertEquals("Carlos", tutor.getNome());
    }

    @Test
    public void deveCriarTutorComCPF() {
        tutor.setCPF("000.000.000-00");
        assertEquals("000.000.000-00", tutor.getCPF());
    }

    // Notificações

    @Test
    public void deveReceberNotificacaoAoContinuarAtendimento() {
        AtendimentoEstadoAgendado estado = AtendimentoEstadoAgendado.getInstance();
        estado.addObserver(tutor);

        atendimento.continuar();

        assertNotNull(tutor.getUltimaNotificacao());
        estado.deleteObserver(tutor);
    }

    @Test
    public void deveReceberNotificacaoAoCancelarAtendimento() {
        AtendimentoEstadoAgendado estado = AtendimentoEstadoAgendado.getInstance();
        estado.addObserver(tutor);

        atendimento.cancelar();

        assertNotNull(tutor.getUltimaNotificacao());
        estado.deleteObserver(tutor);
    }

    @Test
    public void deveReceberNotificacaoAoFinalizarAtendimento() {
        atendimento.continuar();
        AtendimentoEstadoEmAndamento estado = AtendimentoEstadoEmAndamento.getInstance();
        estado.addObserver(tutor);

        atendimento.finalizar();

        assertNotNull(tutor.getUltimaNotificacao());
        estado.deleteObserver(tutor);
    }

    @Test
    public void deveConterNomeNaNotificacao() {
        AtendimentoEstadoAgendado estado = AtendimentoEstadoAgendado.getInstance();
        estado.addObserver(tutor);

        atendimento.continuar();

        assertTrue(tutor.getUltimaNotificacao().contains("Carlos"));
        estado.deleteObserver(tutor);
    }
}
