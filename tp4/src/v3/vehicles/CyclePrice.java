package v3.vehicles;

import v3.Tarif;

public class CyclePrice extends Tarif {
  private static CyclePrice instance;

  private CyclePrice(int pricePerPassenger, int basePrice, int addedPrice) {
    super(pricePerPassenger, basePrice, addedPrice);
  }

  /**
   * Création de l'instance de classe
   *
   * @return l'instance de classe
   */
  public static CyclePrice createSingleton(int pricePerPassenger, int basePrice, int addedPrice) {
    instance = new CyclePrice(pricePerPassenger, basePrice, addedPrice);
    return instance;
  }

  /**
   * Récupère l'instance de classe
   *
   * @return l'instance de classe
   */
  public static CyclePrice getInstance() {
    return instance;
  }

  /**
   * calcul du tarif
   *
   * @param vehicle le vehicule concerné
   * @return le tarif du vehicule
   */
  public int getPrice(Vehicle vehicle) {
    return this.getBasePrice() + this.getPricePerPassenger() * vehicle.getPassagers();
  }
}
