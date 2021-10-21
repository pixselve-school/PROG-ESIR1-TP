package v3.comparators;

import v3.vehicles.Vehicle;

public class ComparateurTarif extends Comparateur {
  private final VehiclePrice getVehiclePrice;

  public ComparateurTarif(VehiclePrice getVehiclePrice, boolean natualOrder) {
    super(natualOrder);
    this.getVehiclePrice = getVehiclePrice;
  }
  public ComparateurTarif(VehiclePrice getVehiclePrice) {
    super(true);
    this.getVehiclePrice = getVehiclePrice;
  }

  protected int doCompare(Vehicle o1, Vehicle o2) {
    return Float.compare(this.getVehiclePrice.getVehiclePrice(o1), this.getVehiclePrice.getVehiclePrice(o2));
  }
}
