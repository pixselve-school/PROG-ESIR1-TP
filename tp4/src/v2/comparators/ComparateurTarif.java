package v2.comparators;

import v2.vehicles.Vehicle;

public class ComparateurTarif extends Comparateur {
  public ComparateurTarif(boolean natualOrder) {
    super(natualOrder);
  }
  public ComparateurTarif() {
    super(true);
  }

  protected int doCompare(Vehicle o1, Vehicle o2) {
    return Float.compare(o1.calculerTarif(), o2.calculerTarif());
  }
}
