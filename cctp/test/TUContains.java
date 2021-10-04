import org.junit.Test;
import static org.junit.Assert.*;

public class TUContains extends ATU {
	
	@Test
	public void testContains() {
		for (int i = 0 ; i < this.smallTab.size() ; i++) {
			assertTrue(this.smallTab.contains(i));
		}
		for (int i = this.smallTab.size() ; i < this.smallTab.size() * 2 ; i++) {
			assertFalse(this.smallTab.contains(i));
		}
		this.checkIntegrityOfVariables();
	}
	
	@Test
	public void testEmpty() {
		for (int i = 0 ; i < this.smallTab.size() ; i++) {
			assertFalse(this.emptyTab.contains(i));
		}
		this.checkIntegrityOfVariables();
	}
	

}
