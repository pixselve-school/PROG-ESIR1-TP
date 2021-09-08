package td2;

import java.util.Arrays;
import java.util.Comparator;

public class Catalogue {
  private SpecifArticle [] listeArticles ;
  private int nbArticles;

  public void trier(Comparator<SpecifArticle> c) {
    Arrays.sort(this.listeArticles, 0, nbArticles);
  }
  public void trier() {
    this.trier(Comparator.comparing(SpecifArticle::designation));
  }
}
