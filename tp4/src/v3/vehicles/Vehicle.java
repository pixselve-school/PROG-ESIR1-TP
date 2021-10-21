package v3.vehicles;

import java.util.Random;

public class Vehicle implements IVehicule, Cloneable {

  private final int length;
  private final int passengerCount;
  private final String registration;

  public Vehicle(int length, int passengerCount, String registration) {
    this.length = length;
    this.passengerCount = passengerCount;
    this.registration = registration;
  }

  public int getLongueur() {
    return this.length;
  }

  public int getPassagers() {
    return this.passengerCount;
  }

  public String getImmatriculation() {
    return this.registration;
  }

  @Override
  public Vehicle clone() {
    try {
      return (Vehicle) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  /**
   * Génère un véhicule aléatoire
   *
   * @param random une classe random
   * @return un véhicule aléatoire
   */
  public static Vehicle random(Random random, String registration) {
    return switch (random.nextInt(4)) {
      case 0 -> Auto.random(random, registration);
      case 1 -> Bus.random(random, registration);
      case 2 -> Ambulance.random(random, registration);
      default -> Cycle.random(random, registration);
    };
  }
}
