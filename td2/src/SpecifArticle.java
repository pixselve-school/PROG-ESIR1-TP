public interface SpecifArticle {
  // Designation de l’article
  public String designation();

  // Quantite en stock
  public int quantite();

  // Prix HT
  public double prixHT();

  // Prix TTC = prix HT * taux de TVA (1.196)
  public double prixTTC();

  // Augmenter le stock de la quantite q ; q > 0
  public void ajoute(int q);

  // Reduire le stock de la quantite q ; 0 < q <= quantite
  public void retirer(int q);

}
