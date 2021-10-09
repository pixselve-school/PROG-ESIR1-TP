package v2.vehicles;

import java.util.Random;

public class Auto extends Vehicle {
  private final boolean allTerrain;

  public Auto(int passengerCount, String registration, boolean allTerrain) {
    super(allTerrain ? 350 : 100, 0, 2, passengerCount, registration);
    this.allTerrain = allTerrain;
  }

  @Override
  public String toString() {
    return "%s %s ( %d passagers ) [%s]".formatted(this.allTerrain ? "\uD83D\uDE98" : "\uD83D\uDE99", this.allTerrain ? "Auto Tout Terrain" : "Auto", this.getPassagers(), this.getImmatriculation());
  }

  /**
   * Génère un véhicule aléatoire
   *
   * @param random une classe random
   * @return un véhicule aléatoire
   */
  public static Auto random(Random random) {
    return new Auto(random.nextInt(4), generateRegistration(random), random.nextBoolean());
  }
}
