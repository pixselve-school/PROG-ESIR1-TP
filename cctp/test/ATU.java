import org.junit.Before;

import types.Block;
import types.Tableau;

import static org.junit.Assert.*;

public abstract class ATU {
	
	protected Tableau<Integer> emptyTab;
	
	protected Tableau<Integer> smallTab;
	
	protected Tableau<Integer> largeTab;
	
	@Before
	public void setup() {
		emptyTab = new Block<>(1);
		smallTab = new Block<>(5);
		largeTab = new Block<>(10);
		for (int i = 0 ; i < 5 ; i++) {
			smallTab.push_back(i);
		}
		for (int i = 0 ; i < 10 ; i++) {
			largeTab.push_back(i);
		}
	}
	
	public void checkIntegrityOfVariables() {
		assertEquals(5, smallTab.size());
		assertEquals(10, largeTab.size());
		for (int i = 0 ; i < 5 ; i++) {
			assertEquals(i, (int)smallTab.get(i));
		}
		for (int i = 5 ; i < 10 ; i++) {
			assertEquals(i, (int)largeTab.get(i));
		}
	}
}
