package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // =========================
    // Testes de soma
    // =========================

    @Test
    void deveSomarDoisNumerosPositivos() {
        assertEquals(8, calculadora.soma(3, 5));
    }

    @Test
    void deveSomarNumerosNegativos() {
        assertEquals(-8, calculadora.soma(-3, -5));
    }

    @Test
    void deveSomarNumeroPositivoComNegativo() {
        assertEquals(2, calculadora.soma(5, -3));
    }

    @Test
    void deveSomarComZero() {
        assertEquals(5, calculadora.soma(5, 0));
        assertEquals(5, calculadora.soma(0, 5));
    }

    @Test
    void deveSomarValoresMaximosSemOverflowEsperado() {
        assertEquals(Integer.MAX_VALUE, calculadora.soma(Integer.MAX_VALUE, 0));
    }

    // =========================
    // Testes de subtração
    // =========================

    @Test
    void deveSubtrairDoisNumerosPositivos() {
        assertEquals(2, calculadora.subtracao(5, 3));
    }

    @Test
    void deveRetornarResultadoNegativoNaSubtracao() {
        assertEquals(-2, calculadora.subtracao(3, 5));
    }

    @Test
    void deveSubtrairNumerosNegativos() {
        assertEquals(2, calculadora.subtracao(-3, -5));
    }

    @Test
    void deveSubtrairComZero() {
        assertEquals(5, calculadora.subtracao(5, 0));
        assertEquals(-5, calculadora.subtracao(0, 5));
    }

    @Test
    void deveRetornarZeroAoSubtrairNumerosIguais() {
        assertEquals(0, calculadora.subtracao(10, 10));
    }

    // =========================
    // Testes de multiplicação
    // =========================

    @Test
    void deveMultiplicarDoisNumerosPositivos() {
        assertEquals(20, calculadora.multiplicacao(4, 5));
    }

    @Test
    void deveMultiplicarNumeroPositivoPorNegativo() {
        assertEquals(-20, calculadora.multiplicacao(4, -5));
    }

    @Test
    void deveMultiplicarDoisNumerosNegativos() {
        assertEquals(20, calculadora.multiplicacao(-4, -5));
    }

    @Test
    void deveRetornarZeroAoMultiplicarPorZero() {
        assertEquals(0, calculadora.multiplicacao(10, 0));
        assertEquals(0, calculadora.multiplicacao(0, 10));
    }

    @Test
    void deveMultiplicarPorUm() {
        assertEquals(10, calculadora.multiplicacao(10, 1));
        assertEquals(-10, calculadora.multiplicacao(-10, 1));
    }

    // =========================
    // Testes de divisão
    // =========================

    @Test
    void deveDividirDoisNumerosPositivos() {
        assertEquals(5, calculadora.divisao(10, 2));
    }

    @Test
    void deveDividirNumeroPositivoPorNegativo() {
        assertEquals(-5, calculadora.divisao(10, -2));
    }

    @Test
    void deveDividirDoisNumerosNegativos() {
        assertEquals(5, calculadora.divisao(-10, -2));
    }

    @Test
    void deveRetornarZeroQuandoNumeradorForZero() {
        assertEquals(0, calculadora.divisao(0, 10));
    }

    @Test
    void deveRealizarDivisaoInteira() {
        assertEquals(3, calculadora.divisao(10, 3));
    }

    @Test
    void deveLancarArithmeticExceptionAoDividirPorZero() {
        assertThrows(
            ArithmeticException.class,
            () -> calculadora.divisao(10, 0)
        );
    }

    // =========================
    // Testes de somatória
    // =========================

    @Test
    void deveCalcularSomatoriaDeZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    void deveCalcularSomatoriaDeUm() {
        assertEquals(1, calculadora.somatoria(1));
    }

    @Test
    void deveCalcularSomatoriaDeCinco() {
        assertEquals(15, calculadora.somatoria(5));
    }

    @Test
    void deveCalcularSomatoriaDeDez() {
        assertEquals(55, calculadora.somatoria(10));
    }

    @Test
    void deveRetornarZeroParaNumeroNegativo() {
        assertEquals(0, calculadora.somatoria(-1));
    }

    @Test
    void deveRetornarZeroParaNumeroNegativoGrande() {
        assertEquals(0, calculadora.somatoria(-100));
    }

    // =========================
    // Testes de ehPositivo
    // =========================

    @Test
    void deveRetornarTrueParaNumeroPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    void deveRetornarTrueParaZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    void deveRetornarFalseParaNumeroNegativo() {
        assertFalse(calculadora.ehPositivo(-10));
    }

    @Test
    void deveRetornarFalseParaMenorValorInteiro() {
        assertFalse(calculadora.ehPositivo(Integer.MIN_VALUE));
    }

    // =========================
    // Testes de compara
    // =========================

    @Test
    void deveRetornarZeroQuandoNumerosForemIguais() {
        assertEquals(0, calculadora.compara(10, 10));
    }

    @Test
    void deveRetornarUmQuandoPrimeiroNumeroForMaior() {
        assertEquals(1, calculadora.compara(10, 5));
    }

    @Test
    void deveRetornarMenosUmQuandoPrimeiroNumeroForMenor() {
        assertEquals(-1, calculadora.compara(5, 10));
    }

    @Test
    void deveCompararNumerosNegativos() {
        assertEquals(1, calculadora.compara(-5, -10));
        assertEquals(-1, calculadora.compara(-10, -5));
        assertEquals(0, calculadora.compara(-5, -5));
    }

    @Test
    void deveCompararZeroComNumerosPositivos() {
        assertEquals(-1, calculadora.compara(0, 5));
        assertEquals(1, calculadora.compara(5, 0));
        assertEquals(0, calculadora.compara(0, 0));
    }

    @Test
    void deveCompararLimitesDeInteiros() {
        assertEquals(
            -1,
            calculadora.compara(Integer.MIN_VALUE, Integer.MAX_VALUE)
        );

        assertEquals(
            1,
            calculadora.compara(Integer.MAX_VALUE, Integer.MIN_VALUE)
        );
    }
}