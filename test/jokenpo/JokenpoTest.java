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

	@Test
	public void testJogador1Vence() {
		assertEquals(1, jokenpo.jogar(1, 2));
	}

	@Test
	public void testJogador2Vence() {
		assertEquals(2, jokenpo.jogar(2, 1));
	}

	@Test
	public void testEmpate() {
		assertEquals(0, jokenpo.jogar(1, 1));
	}

    @Test
	public void testeNumeroErrado() {
		assertEquals(-1, jokenpo.jogar(1, 1));
	}
}