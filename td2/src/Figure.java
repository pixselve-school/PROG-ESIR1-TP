public interface Figure {
  /**
   * @return le genre de la figure geometrique
   */
  public String genre();

  /**
   * @param x et y : coordonnees du point a tester
   * @return vrai si le point est contenu dans la figure geometrique
   */
  public boolean inside(double x, double y);

}
