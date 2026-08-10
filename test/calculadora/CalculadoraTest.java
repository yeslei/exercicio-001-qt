package calculadora;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@Test
	public void testComparaNumeros() {
		assertAll("resultado da comparacao",
				() -> assertEquals(0, calc.compara(12, 12)),
				() -> assertEquals(1, calc.compara(30, 18)),
				() -> assertEquals(-1, calc.compara(7, 14))
				);
	}

	@Test
	public void testSomatoriaAteQuatro() {
		assertEquals(10, calc.somatoria(4));
	}

	@Test
	public void testMultiplicacaoComNegativo() {
		assertEquals(-21, calc.multiplicacao(3, -7));
	}

	@Test
	public void testDivisaoExata() {
		assertEquals(6, calc.divisao(42, 7));
	}

	@Test
	public void testSubtracaoNegativa() {
		assertEquals(-8, calc.subtracao(5, 13));
	}

	@Test
	public void testSomaComNegativo() {
		assertEquals(2, calc.soma(9, -7));
	}

	@Test
	public void testZeroPositivo() {
		assertTrue(calc.ehPositivo(0));
	}

}
