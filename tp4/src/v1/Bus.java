package v1;

public class Bus extends Vehicule {

  public Bus(int length, int passengerCount, String registration) {
    super(200, 50, length, passengerCount, registration);
  }

  @Override
  public String toString() {
    return "Bus ( longueur: %d - %d passagers )".formatted(this.getLongueur(), this.getPassagers());
  }
}
