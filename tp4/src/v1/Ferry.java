package v1;

import java.util.Comparator;

/**
 * Un ferry transporte des véhicules
 */
public class Ferry {
  private final int lengthCapacity;
  private final int passengerCapacity;
  private final FerryList<Vehicle> vehicles;
  private int length;
  private int passengers;

  public Ferry(int lengthCapacity, int passengerCapacity) {
    this.lengthCapacity = lengthCapacity;
    this.passengerCapacity = passengerCapacity;
    vehicles = new FerryList<>();
  }

  // accesseurs
  public int getCapaLongueur() {
    return this.lengthCapacity;
  }

  public int getCapaPassagers() {
    return this.passengerCapacity;
  }

  public int getLongueur() {
    return this.length;
  }

  public int getPassagers() {
    return this.passengers;
  }

  /**
   * Récupère la longueur disponible
   *
   * @return la longueur disponible
   */
  public int getAvailableLength() {
    return this.getCapaLongueur() - this.getLongueur();
  }

  /**
   * Récupère le nombre de passagers disponible
   *
   * @return le nombre de passagers disponible
   */
  public int getAvailablePassengers() {
    return this.getCapaPassagers() - this.getPassagers();
  }

  /**
   * ajouter un véhicule dans le ferry.
   * sans effet s'il n'y a plus de place
   *
   * @param v : véhicule à ajouter
   * @return vrai si l'ajout a eu lieu, faux sinon
   */
  public boolean ajouter(Vehicle v) {
    if (this.getPassagers() + v.getPassagers() <= this.getCapaPassagers() && this.getLongueur() + v.getLongueur() <= this.getCapaLongueur()) {
      this.vehicles.push(v.clone());
      this.passengers += v.getPassagers();
      this.length += v.getLongueur();
      return true;
    } else {
      return false;
    }
  }

  public void trier() {
    this.vehicles.sort(Comparator.comparingInt(Vehicle::getLongueur));
  }

  /**
   * calculer le tarif de l'ensemble des véhicules présents dans le ferry
   *
   * @return le tarif de l'ensemble des véhicules présents dans le ferry
   */
  public float calculerTarif() {
    return this.vehicles.stream().map(Vehicle::calculerTarif).reduce(0.0F, Float::sum);
  }

  /**
   * Représentation affichable du ferry
   *
   * @return la représentation affichable du ferry
   */
  public String toString() {
    StringBuilder result = new StringBuilder("⎯ ⛴ Ferry ⎯\n☑️ Longueur disponible: %s\n☑️ Nombre de place disponible: %s\n️☑️ Tarif total des véhicules: %s€\n☑️ Véhicules:\n".formatted(this.getAvailableLength(), this.getAvailablePassengers(), this.calculerTarif()));
    for (Vehicle vehicle : this.vehicles) {
      result.append(" ").append(vehicle.toString()).append("\n");
    }
    return result.toString();
  }
}
