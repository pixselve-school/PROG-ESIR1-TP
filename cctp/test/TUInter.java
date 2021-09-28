import org.junit.Test;

import types.Tableau;
import static org.junit.Assert.*;

public class TUInter extends ATU {
	
	@Test
	public void testInter() {
		Tableau<Integer> inter = this.smallTab.inter(this.smallTab);
		for (int i = 0 ; i < this.smallTab.size() ; i++) {
			assertTrue(inter.contains(i));
		}
		assertEquals(this.smallTab.size(), inter.size());
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testInter2() {
		Tableau<Integer> inter = this.largeTab.inter(this.smallTab);
		for (int i = 0 ; i < this.smallTab.size() ; i++) {
			assertTrue(inter.contains(i));
		}
		assertEquals(this.smallTab.size(), inter.size());
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testInter3() {
		Tableau<Integer> inter = this.smallTab.inter(this.largeTab);
		for (int i = 0 ; i < this.smallTab.size() ; i++) {
			assertTrue(inter.contains(i));
		}
		assertEquals(this.smallTab.size(), inter.size());
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testInterOnEmpty() {
		Tableau<Integer> inter = this.emptyTab.inter(this.smallTab);
		assertTrue(inter.empty());
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testInterEmpty() {
		Tableau<Integer> inter = this.smallTab.inter(this.emptyTab);
		assertTrue(inter.empty());
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testInterEmptyOnEmpty() {
		Tableau<Integer> inter = this.emptyTab.inter(this.emptyTab);
		assertTrue(inter.empty());
		this.checkIntegrityOfVariables();
	}
	

}
