package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe de teste Jokenpo")
public class JokenpoTest {

    private Jokenpo jokenpo;

    @BeforeEach
    public void inicializaJokenpo() {
        jokenpo = new Jokenpo();
    }

    // ==========================
    // Jogador 1 vence
    // ==========================

    @Test
    @DisplayName("Jogador 1 vence com papel contra pedra")
    public void jogador1VencePapelContraPedra() {
        assertEquals(1, jokenpo.jogar(1, 2));
    }

    @Test
    @DisplayName("Jogador 1 vence com pedra contra tesoura")
    public void jogador1VencePedraContraTesoura() {
        assertEquals(1, jokenpo.jogar(2, 3));
    }

    @Test
    @DisplayName("Jogador 1 vence com tesoura contra papel")
    public void jogador1VenceTesouraContraPapel() {
        assertEquals(1, jokenpo.jogar(3, 1));
    }

    // ==========================
    // Jogador 2 vence
    // ==========================

    @Test
    @DisplayName("Jogador 2 vence com pedra contra papel")
    public void jogador2VencePedraContraPapel() {
        assertEquals(2, jokenpo.jogar(2, 1));
    }

    @Test
    @DisplayName("Jogador 2 vence com tesoura contra pedra")
    public void jogador2VenceTesouraContraPedra() {
        assertEquals(2, jokenpo.jogar(3, 2));
    }

    @Test
    @DisplayName("Jogador 2 vence com papel contra tesoura")
    public void jogador2VencePapelContraTesoura() {
        assertEquals(2, jokenpo.jogar(1, 3));
    }

    // ==========================
    // Empates
    // ==========================

    @Test
    public void empatePapel() {
        assertEquals(0, jokenpo.jogar(1, 1));
    }

    @Test
    public void empatePedra() {
        assertEquals(0, jokenpo.jogar(2, 2));
    }

    @Test
    public void empateTesoura() {
        assertEquals(0, jokenpo.jogar(3, 3));
    }

    // ==========================
    // Opções inválidas
    // ==========================

    @Test
    public void jogador1ComOpcaoZero() {
        assertEquals(-1, jokenpo.jogar(0, 1));
    }

    @Test
    public void jogador2ComOpcaoZero() {
        assertEquals(-1, jokenpo.jogar(1, 0));
    }

    @Test
    public void jogador1ComOpcaoMaiorQueTres() {
        assertEquals(-1, jokenpo.jogar(4, 1));
    }

    @Test
    public void jogador2ComOpcaoMaiorQueTres() {
        assertEquals(-1, jokenpo.jogar(1, 4));
    }

    @Test
    public void jogador1ComOpcaoNegativa() {
        assertEquals(-1, jokenpo.jogar(-1, 1));
    }

    @Test
    public void jogador2ComOpcaoNegativa() {
        assertEquals(-1, jokenpo.jogar(1, -1));
    }

    @Test
    public void ambosComOpcoesInvalidas() {
        assertEquals(-1, jokenpo.jogar(0, 4));
    }
}