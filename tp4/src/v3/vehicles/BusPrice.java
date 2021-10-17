package v3.vehicles;

import v3.Tarif;

public class BusPrice extends Tarif {
  private static BusPrice instance;

  private BusPrice(float pricePerPassenger, int basePrice, int addedPrice) {
    super(pricePerPassenger, basePrice, addedPrice);
  }

  /**
   * Création de l'instance de classe
   *
   * @return l'instance de classe
   */
  public static BusPrice createSingleton(float pricePerPassenger, int basePrice, int addedPrice) {
    instance = new BusPrice(pricePerPassenger, basePrice, addedPrice);
    return instance;
  }

  /**
   * Récupère l'instance de classe
   *
   * @return l'instance de classe
   */
  public static BusPrice getInstance() {
    return instance;
  }

  /**
   * calcul du tarif
   *
   * @param vehicle le vehicule concerné
   * @return le tarif du vehicule
   */
  public float getPrice(Vehicle vehicle) {
    return this.getBasePrice() + this.getPricePerPassenger() * vehicle.getPassagers() + this.getAddedPrice() * vehicle.getLongueur();
  }
}
