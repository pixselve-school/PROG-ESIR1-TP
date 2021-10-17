package v3.vehicles;

import v3.Tarif;

public class AutoPrice extends Tarif {
  private static AutoPrice instance;

  private AutoPrice(float pricePerPassenger, int basePrice, int addedPrice) {
    super(pricePerPassenger, basePrice, addedPrice);
  }

  /**
   * Création de l'instance de classe
   *
   * @return l'instance de classe
   */
  public static AutoPrice createSingleton(float pricePerPassenger, int basePrice, int addedPrice) {
    instance = new AutoPrice(pricePerPassenger, basePrice, addedPrice);
    return instance;
  }

  /**
   * Récupère l'instance de classe
   *
   * @return l'instance de classe
   */
  public static AutoPrice getInstance() {
    return instance;
  }

  /**
   * calcul du tarif
   *
   * @param vehicle le vehicule concerné
   * @return le tarif du vehicule
   */
  public float getPrice(Vehicle vehicle) {
    return this.getBasePrice() + this.getPricePerPassenger() * vehicle.getPassagers();
  }
}
