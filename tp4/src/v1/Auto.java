package v1;

public class Auto extends Vehicle {

  public Auto(int passengerCount, String registration, boolean allTerrain) {
    super(allTerrain ? 350 : 100, 0, 2, passengerCount, registration);
  }

  @Override
  public String toString() {
    return "\uD83D\uDE98 Auto ( %d passagers )".formatted(this.getPassagers());
  }
}
