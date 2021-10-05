import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import types.ABinHuffman;
import types.Couple;
import types.ListeABH;

import static org.junit.Assert.*;

public class CodageHuffmanTest {
  ABinHuffman aBinHuffman1;
  ABinHuffman aBinHuffman2;
  ABinHuffman aBinHuffman3;
  ABinHuffman aBinHuffman4;



  @Before
  public void setUp() throws Exception {
    this.aBinHuffman1 = new ABinHuffman();
    this.aBinHuffman1.setValeur(new Couple<>('1', 1));

    this.aBinHuffman2 = new ABinHuffman();
    this.aBinHuffman2.setValeur(new Couple<>('2', 2));

    this.aBinHuffman3 = new ABinHuffman();
    this.aBinHuffman3.setValeur(new Couple<>('3', 3));

    this.aBinHuffman4 = new ABinHuffman();
    this.aBinHuffman4.setValeur(new Couple<>('4', 4));


  }

  @Test
  public void addInPlace_empty() {
    ListeABH list = new ListeABH();
    CodageHuffman.addInPlace(list, aBinHuffman1);
    ListeABH list2 = new ListeABH();
    list2.add(aBinHuffman1);
    assertEquals(list2, list);
  }

  @Test
  public void addInPlace_1_element_greater() {
    ListeABH list = new ListeABH();
    ListeABH list2 = new ListeABH();

    list.add(aBinHuffman4);

    list2.add(aBinHuffman1);
    list2.add(aBinHuffman4);

    CodageHuffman.addInPlace(list, aBinHuffman1);

    assertEquals(list2, list);
  }

  @Test
  public void addInPlace_1_element_lesser() {
    ListeABH list = new ListeABH();
    ListeABH list2 = new ListeABH();

    list.add(aBinHuffman1);

    list2.add(aBinHuffman1);
    list2.add(aBinHuffman4);

    CodageHuffman.addInPlace(list, aBinHuffman4);

    assertEquals(list2, list);
  }


}