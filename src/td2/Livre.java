package td2;

public class Livre extends Article implements SpecifLivre {
  private final int nombrePages;
  private final String numeroISBN;

  public Livre(String designation, int quantite, double prixHT, int nombrePages, String numeroISBN) {
    super(designation, quantite, prixHT);
    this.numeroISBN = numeroISBN;
    this.nombrePages = nombrePages;
  }

  public int nombrePages() {
    return this.nombrePages;
  }

  public String numeroISBN() {
    return this.numeroISBN;
  }

  @Override
  public String toString() {
    return "\"%s\", %s (%s en stock ) ISBN %s (%s pages)".formatted(this.designation(), this.prixHT(), this.quantite(), this.numeroISBN, this.nombrePages);
  }
}
