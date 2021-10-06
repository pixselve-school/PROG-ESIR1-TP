package v1;

import java.util.Stack;

/**
 * Un ferry transporte des véhicules
 */
public class Ferry {
  private final int lengthCapacity;
  private final int passengerCapacity;
  private final Stack<Vehicule> vehicles;

  public Ferry(int lengthCapacity, int passengerCapacity) {
    this.lengthCapacity = lengthCapacity;
    this.passengerCapacity = passengerCapacity;
    vehicles = new Stack<>();
  }

  // accesseurs
  public int getCapaLongueur() {
    return this.lengthCapacity;
  }

  public int getCapaPassagers() {
    return this.passengerCapacity;
  }

  public int getLongueur() {
    return 0;
  }

  public int getPassagers() {
    return 0;
  }

  /**
   * ajouter un véhicule dans le ferry.
   * sans effet s'il n'y a plus de place
   *
   * @param v : véhicule à ajouter
   * @return vrai si l'ajout a eu lieu, faux sinon
   */
  public boolean ajouter(Vehicule v) {
    if (this.getPassagers() + v.getPassagers() <= this.getCapaPassagers() && this.getLongueur() + v.getLongueur() <= this.getCapaLongueur()) {
      this.vehicles.push(v);
      return true;
    } else {
      return false;
    }
  }

  // calculer le tarif de l'ensemble des véhicules présents dans le ferry
  public float calculerTarif() {
    return this.vehicles.stream().map(Vehicule::calculerTarif).reduce(0.0F, Float::sum);
  }

  // représentation affichable du ferry
  public String toString() {
    StringBuilder result = new StringBuilder();
    return new StringBuilder(this.vehicles.stream().map(Object::toString)).toString();
  }
}
