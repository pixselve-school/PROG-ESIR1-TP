import org.junit.Test;

import types.Tableau;
import static org.junit.Assert.*;

public class TUXor extends ATU {
	
	@Test
	public void testXor() {
		Tableau<Integer> xor = this.smallTab.xor(this.smallTab);
		assertTrue(xor.empty());
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testXor2() {
		Tableau<Integer> xor = this.smallTab.xor(this.largeTab);
		for (int i = this.smallTab.size() ; i < this.largeTab.size() ; i++) {
			assertTrue(xor.contains(i));
		}
		assertEquals(this.smallTab.size(), xor.size());
		this.checkIntegrityOfVariables();
	}
	
	
	@Test
	public void testXorOnEmpty() {
		Tableau<Integer> xor = this.emptyTab.xor(this.smallTab);
		for (int i = 0 ; i < this.smallTab.size() ; i++) {
			assertTrue(xor.contains(i));
		}
		assertEquals(this.smallTab.size(), xor.size());
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testXorEmpty() {
		Tableau<Integer> xor = this.smallTab.xor(this.emptyTab);
		for (int i = 0 ; i < this.smallTab.size() ; i++) {
			assertTrue(xor.contains(i));
		}
		assertEquals(this.smallTab.size(), xor.size());
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testXorEmptyOnEmpty() {
		Tableau<Integer> xor = this.emptyTab.xor(this.emptyTab);
		assertTrue(xor.empty());
		this.checkIntegrityOfVariables();
	}
	

}
