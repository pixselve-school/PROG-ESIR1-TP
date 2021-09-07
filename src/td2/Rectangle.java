package td2;

public class Rectangle implements Figure {
  Coordinate center;
  int h;
  int l;

  public Rectangle(int x, int y, int l, int h) {
    this.center = new Coordinate(x, y);
    this.h = h;
    this.l = l;
  }

  /**
   * @return le genre de la figure geometrique
   */
  public String genre() {
    return "Rectangle";
  }

  /**
   * @param x et y : coordonnees du point a tester
   * @param y
   * @return vrai si le point est contenu dans la figure geometrique
   */
  public boolean inside(double x, double y) {
    return false;
  }
}
