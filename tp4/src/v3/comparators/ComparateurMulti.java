package v3.comparators;

import v3.vehicles.Vehicle;

import java.util.Comparator;

public class ComparateurMulti extends Comparateur {
  private final Comparator<Vehicle> comparator;

  public ComparateurMulti(Comparator<Vehicle> comparator1, Comparator<Vehicle> comparator2, boolean natualOrder) {
    super(natualOrder);
    this.comparator = comparator1.thenComparing(comparator2);
  }
  public ComparateurMulti(Comparator<Vehicle> comparator1, Comparator<Vehicle> comparator2) {
    super(true);
    this.comparator = comparator1.thenComparing(comparator2);
  }

  protected int doCompare(Vehicle o1, Vehicle o2) {
    return this.comparator.compare(o1, o2);
  }
}
