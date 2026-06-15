
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtendimentoTest {

    Atendimento atendimento;

    @BeforeEach
    public void setUp() {
        atendimento = new Atendimento();
    }

    // Atendimento agendado

    @Test
    public void deveContinuarAtendimentoAgendado() {
        atendimento.setEstado(AtendimentoEstadoAgendado.getInstance());
        assertTrue(atendimento.continuar());
        assertEquals(AtendimentoEstadoEmAndamento.getInstance(), atendimento.getEstado());
    }

    @Test
    public void deveCancelarAtendimentoAgendado() {
        atendimento.setEstado(AtendimentoEstadoAgendado.getInstance());
        assertTrue(atendimento.cancelar());
        assertEquals(AtendimentoEstadoCancelado.getInstance(), atendimento.getEstado());
    }

    @Test
    public void naoDeveFinalizarAtendimentoAgendado() {
        atendimento.setEstado(AtendimentoEstadoAgendado.getInstance());
        assertFalse(atendimento.finalizar());
    }

    // Atendimento em andamento

    @Test
    public void deveFinalizarAtendimentoEmAndamento() {
        atendimento.setEstado(AtendimentoEstadoEmAndamento.getInstance());
        assertTrue(atendimento.finalizar());
        assertEquals(AtendimentoEstadoFinalizado.getInstance(), atendimento.getEstado());
    }

    @Test
    public void naoDeveCancelarAtendimentoEmAndamento() {
        atendimento.setEstado(AtendimentoEstadoEmAndamento.getInstance());
        assertFalse(atendimento.cancelar());
    }

    @Test
    public void naoDeveContinuarAtendimentoEmAndamento() {
        atendimento.setEstado(AtendimentoEstadoEmAndamento.getInstance());
        assertFalse(atendimento.continuar());
    }

    // Atendimento finalizado

    @Test
    public void naoDeveContinuarAtendimentoFinalizado() {
        atendimento.setEstado(AtendimentoEstadoFinalizado.getInstance());
        assertFalse(atendimento.continuar());
    }

    @Test
    public void naoDeveCancelarAtendimentoFinalizado() {
        atendimento.setEstado(AtendimentoEstadoFinalizado.getInstance());
        assertFalse(atendimento.cancelar());
    }

    @Test
    public void naoDeveFinalizarAtendimentoFinalizado() {
        atendimento.setEstado(AtendimentoEstadoFinalizado.getInstance());
        assertFalse(atendimento.finalizar());
    }

    // Atendimento cancelado

    @Test
    public void naoDeveContinuarAtendimentoCancelado() {
        atendimento.setEstado(AtendimentoEstadoCancelado.getInstance());
        assertFalse(atendimento.continuar());
    }

    @Test
    public void naoDeveCancelarAtendimentoCancelado() {
        atendimento.setEstado(AtendimentoEstadoCancelado.getInstance());
        assertFalse(atendimento.cancelar());
    }

    @Test
    public void naoDeveFinalizarAtendimentoCancelado() {
        atendimento.setEstado(AtendimentoEstadoCancelado.getInstance());
        assertFalse(atendimento.finalizar());
    }
}
