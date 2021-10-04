import static org.junit.Assert.assertEquals;

import org.junit.Test;

import types.Block;
import types.Tableau;

public class BlockConcatTest {
	
	@Test
	public void testConcat() {
		Block<Integer> a = new Block<>(10);
		Block<Integer> b = new Block<>(10);
		for (int i = 0 ; i < 5 ; i++) {
			a.push_back(i);
		}
		for (int i = 5 ; i < 10 ; i++) {
			b.push_back(i);
		}
		assertEquals(5, a.size());
		assertEquals(5, b.size());
		a.concat(b);
		assertEquals(10, a.size());
		assertEquals(5, b.size());
		for (int i = 0 ; i < a.size() ; i++) {
			assertEquals(i, (int)a.get(i));
		}
	}
	
	@Test
	public void testConcatOnAbstraction() {
		Block<Integer> a = new Block<>(10);
		Tableau<Integer> b = new Block<>(10);
		for (int i = 0 ; i < 5 ; i++) {
			a.push_back(i);
		}
		for (int i = 5 ; i < 10 ; i++) {
			b.push_back(i);
		}
		assertEquals(5, a.size());
		assertEquals(5, b.size());
		a.concat(b);
		assertEquals(10, a.size());
		assertEquals(5, b.size());
		for (int i = 0 ; i < a.size() ; i++) {
			assertEquals(i, (int)a.get(i));
		}
	}
	
	@Test
	public void testConcatOnEmpty() {
		Block<Integer> a = new Block<>(10);
		Tableau<Integer> b = new Block<>(10);
		for (int i = 0 ; i < 5 ; i++) {
			b.push_back(i);
		}
		assertEquals(0, a.size());
		assertEquals(5, b.size());
		a.concat(b);
		assertEquals(5, a.size());
		assertEquals(5, b.size());
		for (int i = 0 ; i < a.size() ; i++) {
			assertEquals(i, (int)a.get(i));
		}
	}
	
	@Test
	public void testConcatEmpty() {
		Block<Integer> a = new Block<>(10);
		Tableau<Integer> b = new Block<>(10);
		for (int i = 0 ; i < 5 ; i++) {
			a.push_back(i);
		}
		assertEquals(5, a.size());
		assertEquals(0, b.size());
		a.concat(b);
		assertEquals(5, a.size());
		assertEquals(0, b.size());
		for (int i = 0 ; i < a.size() ; i++) {
			assertEquals(i, (int)a.get(i));
		}
	}
	
}
