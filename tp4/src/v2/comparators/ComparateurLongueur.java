package v2.comparators;

import v2.vehicles.Vehicle;

public class ComparateurLongueur extends Comparateur {
  public ComparateurLongueur(boolean natualOrder) {
    super(natualOrder);
  }
  public ComparateurLongueur() {
    super(true);
  }

  protected int doCompare(Vehicle o1, Vehicle o2) {
    return Integer.compare(o1.getLongueur(), o2.getLongueur());
  }
}
