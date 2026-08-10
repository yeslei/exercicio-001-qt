package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Teste da classe Carrinho")
public class CarrinhoTest {

	private Carrinho carrinho;
	private Produto caderno;
	private Produto lapis;
	private Produto mochila;
	
	@BeforeEach
	public void preparaCarrinho() {
		carrinho = new Carrinho();
		caderno = new Produto("Caderno", 10.00);
		lapis = new Produto("Lapis", 1.00);
		mochila = new Produto("Mochila", 50.00);
	}
	
	@Test
	public void testRemoveProduto() throws ProdutoNaoEncontradoException {
		carrinho.addItem(caderno);
		carrinho.addItem(lapis);
		carrinho.addItem(mochila);
		
		carrinho.removeItem(lapis);
		
		assertEquals(2, carrinho.getQtdeItems());
		assertEquals(60.00, carrinho.getValorTotal(), 0.001);
	}
	
	@Test
	public void testValorTotalComDoisProdutos() {
		carrinho.addItem(caderno);
		carrinho.addItem(lapis);
		
		assertEquals(11.00, carrinho.getValorTotal(), 0.001);
	}
	
	@Test
	public void testProdutoAusenteLancaExcecao() {
		carrinho.addItem(caderno);
		
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(mochila));
	}
	
	@Test
	public void testCarrinhoNovo() {
		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.001);
	}
	
	@Test
	public void testEsvaziaDepoisDeAdicionar() {
		carrinho.addItem(mochila);
		carrinho.addItem(caderno);
		
		carrinho.esvazia();
		
		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.001);
	}
	
	@Test
	public void testAdicionaProdutoRepetido() {
		carrinho.addItem(lapis);
		carrinho.addItem(lapis);
		
		assertEquals(2, carrinho.getQtdeItems());
		assertEquals(2.00, carrinho.getValorTotal(), 0.001);
	}
}