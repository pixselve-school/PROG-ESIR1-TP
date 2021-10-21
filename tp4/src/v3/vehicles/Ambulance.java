package v3.vehicles;

import java.util.Random;

public class Ambulance extends Auto {
  public Ambulance(int passengerCount, String registration, boolean allTerrain) {
    super(passengerCount, registration, allTerrain);
  }

  /**
   * Génère un véhicule aléatoire
   *
   * @param random une classe random
   * @return un véhicule aléatoire
   */
  public static Ambulance random(Random random, String registration) {
    return new Ambulance(random.nextInt(4), registration, random.nextBoolean());
  }

  @Override
  public String toString() {
    return "\uD83D\uDE91 Ambulance ( %d passagers ) [%s]".formatted(this.getPassagers(), this.getImmatriculation());
  }
}
