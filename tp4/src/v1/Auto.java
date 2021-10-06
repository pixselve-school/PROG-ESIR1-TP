package v1;

public class Auto extends Vehicule {

  public Auto(int passengerCount, String registration, boolean allTerrain) {
    super(allTerrain ? 350 : 100, 0, 2, passengerCount, registration);
  }

  @Override
  public String toString() {
    return "Auto ( %d passagers )".formatted(this.getPassagers());
  }
}
