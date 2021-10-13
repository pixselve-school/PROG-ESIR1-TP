package v3.vehicles;

import v3.Tarif;

public class AmbulancePrice extends Tarif {
  private static AmbulancePrice instance;

  private AmbulancePrice(int pricePerPassenger, int basePrice, int addedPrice) {
    super(pricePerPassenger, basePrice, addedPrice);
  }

  /**
   * Création de l'instance de classe
   *
   * @return l'instance de classe
   */
  public static AmbulancePrice createSingleton(int pricePerPassenger, int basePrice, int addedPrice) {
    instance = new AmbulancePrice(pricePerPassenger, basePrice, addedPrice);
    return instance;
  }

  /**
   * Récupère l'instance de classe
   *
   * @return l'instance de classe
   */
  public static AmbulancePrice getInstance() {
    return instance;
  }

  /**
   * calcul du tarif
   *
   * @param vehicle le vehicule concerné
   * @return le tarif du vehicule
   */
  public int getPrice(Vehicle vehicle) {
    return 0;
  }
}
