package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
    }

    @Test
    void deveCriarCarrinhoVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveAdicionarUmItem() {
        Produto produto = new Produto("Produto 1", 10.0);

        carrinho.addItem(produto);

        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void deveAdicionarMultiplosItens() {
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        Produto produto3 = new Produto("Produto 3", 30.0);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.addItem(produto3);

        assertEquals(3, carrinho.getQtdeItems());
    }

    @Test
    void deveCalcularValorTotalComUmItem() {
        Produto produto = new Produto("Produto 1", 10.0);

        carrinho.addItem(produto);

        assertEquals(10.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveCalcularValorTotalComMultiplosItens() {
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        Produto produto3 = new Produto("Produto 3", 30.0);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.addItem(produto3);

        assertEquals(60.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void deveRemoverItemExistente() throws ProdutoNaoEncontradoException {
        Produto produto = new Produto("Produto 1", 10.0);
        carrinho.addItem(produto);

        carrinho.removeItem(produto);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void deveAtualizarValorTotalAposRemoverItem() throws ProdutoNaoEncontradoException {
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.removeItem(produto1);

        assertEquals(20.0, carrinho.getValorTotal(), 0.001);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void deveLancarExcecaoAoRemoverItemInexistente() {
        Produto produto = new Produto("Produto 1", 10.0);

        assertThrows(
            ProdutoNaoEncontradoException.class,
            () -> carrinho.removeItem(produto)
        );
    }

    @Test
    void deveEsvaziarCarrinho() {
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void devePermitirEsvaziarCarrinhoJaVazio() {
        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    void devePermitirAdicionarMesmoProdutoMaisDeUmaVez() {
        Produto produto = new Produto("Produto 1", 10.0);

        carrinho.addItem(produto);
        carrinho.addItem(produto);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(20.0, carrinho.getValorTotal(), 0.001);
    }
}