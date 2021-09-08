package td2;

public class Intersection implements Figure {
  private final Figure figure1;
  private final Figure figure2;

  public Intersection(Figure figure1, Figure figure2) {
    this.figure1 = figure1;
    this.figure2 = figure2;
  }

  /**
   * @return le genre de la figure geometrique
   */
  public String genre() {
    return "Intersection";
  }

  /**
   * @param x et y : coordonnees du point a tester
   * @param y
   * @return vrai si le point est contenu dans la figure geometrique
   */
  public boolean inside(double x, double y) {
    return figure1.inside(x, y) && figure2.inside(x, y);
  }
}
