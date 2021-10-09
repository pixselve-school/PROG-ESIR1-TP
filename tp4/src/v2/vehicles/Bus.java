package v2.vehicles;

import java.util.Random;

public class Bus extends Vehicle {

  public Bus(int length, int passengerCount, String registration) {
    super(200, 50, length, passengerCount, registration);
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
  public static Bus random(Random random) {
    return new Bus(random.nextInt(100), random.nextInt(100), generateRegistration(random));
  }
}
