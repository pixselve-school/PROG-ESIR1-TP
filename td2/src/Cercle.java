public class Cercle implements Figure {
  Coordinate center;
  int radius;

  public Cercle(int x, int y, int radius) {
    this.center = new Coordinate(x, y);
    this.radius = radius;
  }


  /**
   * @return le genre de la figure geometrique
   */
  public String genre() {
    return "Cercle";
  }

  /**
   * @param x et y : coordonnees du point a tester
   * @param y
   * @return vrai si le point est contenu dans la figure geometrique
   */
  public boolean inside(double x, double y) {
    return Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2) < Math.pow(radius, 2);
  }
}
