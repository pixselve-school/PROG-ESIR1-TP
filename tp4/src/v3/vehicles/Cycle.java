package v3.vehicles;

import java.util.Random;

public class Cycle extends Vehicle {
  public Cycle(int passengerCount, String registration) {
    super(20, 0, 1, passengerCount, registration);
    assert passengerCount <= 1 : "Un cycle ne peut transporter qu’une personne";

  }

  @Override
  public String toString() {
    return "\uD83D\uDEB2 Cycle ( %d passagers ) [%s]".formatted(this.getPassagers(), this.getImmatriculation());
  }
  /**
   * Génère un véhicule aléatoire
   * @param random une classe random
   * @return un véhicule aléatoire
   */
  public static Cycle random(Random random) {
    return new Cycle(random.nextInt(2), generateRegistration(random));
  }
}
