
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    Tutor tutor;

    @BeforeEach
    public void setUp() {
        tutor = new Tutor();
        tutor.setNome("Carlos");
    }

    // Criação de tipos de animal

    @Test
    public void deveCriarAnimalTipoCachorro() {
        IAnimalTipo tipo = AnimalTipoFactory.getTipo("Cachorro");
        assertEquals("Cachorro", tipo.getTipo());
    }

    @Test
    public void deveCriarAnimalTipoGato() {
        IAnimalTipo tipo = AnimalTipoFactory.getTipo("Gato");
        assertEquals("Gato", tipo.getTipo());
    }

    @Test
    public void naoDeveCriarAnimalTipoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> AnimalTipoFactory.getTipo("Hamster"));
    }

    @Test
    public void naoDeveCriarAnimalTipoVazio() {
        assertThrows(IllegalArgumentException.class, () -> AnimalTipoFactory.getTipo(""));
    }

    @Test
    public void deveLancarMensagemCorretaParaTipoInexistente() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> AnimalTipoFactory.getTipo("Papagaio"));
        assertEquals("Tipo de Animal Inexistente", ex.getMessage());
    }

    // Adição de animal ao tutor

    @Test
    public void deveAdicionarAnimalAoTutor() {
        Animal gato = new Animal();
        gato.nome = "Mingau";
        gato.tipo = AnimalTipoFactory.getTipo("Gato");

        assertDoesNotThrow(() -> tutor.adicionarAnimal(gato));
    }

    @Test
    public void deveAdicionarDoisAnimaisAoTutor() {
        Animal gato = new Animal();
        gato.nome = "Mingau";
        gato.tipo = AnimalTipoFactory.getTipo("Gato");

        Animal cachorro = new Animal();
        cachorro.nome = "Rex";
        cachorro.tipo = AnimalTipoFactory.getTipo("Cachorro");

        tutor.adicionarAnimal(gato);
        assertDoesNotThrow(() -> tutor.adicionarAnimal(cachorro));
    }
}
