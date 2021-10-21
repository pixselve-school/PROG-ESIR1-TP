package v3.vehicles;

import java.util.Random;

public class Bus extends Vehicle {

  public Bus(int length, int passengerCount, String registration) {
    super(length, passengerCount, registration);
  }

  @Override
  public String toString() {
    return "\uD83D\uDE8E Bus ( longueur: %d - %d passagers ) [%s]".formatted(this.getLongueur(), this.getPassagers(), this.getImmatriculation());
  }
  /**
   * Génère un véhicule aléatoire
   * @param random une classe random
   * @return un véhicule aléatoire
   */
  public static Bus random(Random random, String registration) {
    return new Bus(random.nextInt(100), random.nextInt(100), registration);
  }
}
