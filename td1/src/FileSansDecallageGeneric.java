import java.util.Scanner;

public class FileSansDecallageGeneric<A> implements FileGeneric<A> {
  private static class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element) {
      this.element = element;
      next = null;
    }

    public int length() {
      if (next == null) {
        return 1;
      } else {
        return 1 + next.length();
      }
    }

    public String toString() {
      if (next == null) {
        return String.valueOf(element);
      } else {
        return element + ", " + next;
      }
    }

    public void add(T element) {
      if (next == null) {
        next = new Node<T>(element);
      } else {
        next.add(element);
      }
    }

    public T getElement() {
      return element;
    }

    public void setElement(T element) {
      this.element = element;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }
  }


  private Node<A> content;

  public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  FileGeneric<Float> file = new FileSansDecallageGeneric(); // Seul changement ici
    while (!file.estPleine()) {
    System.out.print("Veuillez saisir un nombre (-1 pour arreter): ");
    float userValue = scanner.nextFloat();
    if (userValue < 0) break;
    file.ajouter(userValue);
  }
    scanner.close();
    System.out.println(file);
}

  public FileSansDecallageGeneric() {
    content = null;
  }

  /**
   * @return vrai si la file est vide
   * @implNote O(1)
   */
  public boolean estVide() {
    return this.content == null;
  }

  /**
   * @return vrai si la file est pleine
   * @implNote O(1)
   */
  public boolean estPleine() {
    return false;
  }

  /**
   * @return le nombre d’elements presents dans la file
   * @implNote O(1)
   */
  public int getTaille() {
    return content == null ? 0 : content.length();
  }

  /**
   * @param x : valeur a ajouter en fin de file
   * @implNote O(1)
   */
  public void ajouter(A x) {
    if (content == null) {
      content = new Node<>(x);
    } else {
      content.add(x);
    }

  }

  /**
   * supprimer l’element de tete de file .
   * @implNote O(N)
   */
  public void supprimer() {
    if (content != null) {
      content = content.getNext();
    }
  }

  /**
   * @return valeur de l’element en tete de file
   * @implNote O(1)
   */
  public A getTete() {
    return content.element;
  }

  /**
   * @implNote O(N)
   */
  public String toString() {
    return content == null ? "" : content.toString();
  }
}
