package td2;

public class Rectangle implements Figure {
  Coordinate center;
  int h;
  int l;


  /**
   * @param x
   * @param y
   * @param l
   * @param h
   *
   * 1) Cercle c = new Cercle(1.0, 1.0, 0.2); VALIDE
   * 2) Rectangle r = new Rectangle(1.0, 2.0, 1.0, 1.0); NON VALIDE - trop de params
   * 3) Figure f = new Figure(); NON VALIDE - Interface
   * 4) Figure f2 = new Cercle(1.0, 2.0, 2.0); VALIDE
   * 5) Rectangle r2 = new Cercle(1.0, 2.0, 0.2); NON VALIDE - type
   * 6) Cercle c2 = f2; NON VALIDE - cast nécessaire
   *
   */
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
    return y < this.center.getY() + this.h / 2.0 && y > this.center.getY() - this.h / 2.0 && x < this.center.getX() + this.l / 2.0 && x > this.center.getX() - this.l / 2.0;
  }
}
