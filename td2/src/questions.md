### Les instructions suivantes sont-elles valides ou non ? (Justifiez votre réponse)
* `Cercle c = new Cercle(1.0, 1.0, 0.2);` VALIDE
* `Rectangle r = new Rectangle(1.0, 2.0, 1.0, 1.0);` NON VALIDE - trop de params
* `Figure f = new Figure();` NON VALIDE - Interface
* `Figure f2 = new Cercle(1.0, 2.0, 2.0);` VALIDE
* `Rectangle r2 = new Cercle(1.0, 2.0, 0.2);` NON VALIDE - type
* `Cercle c2 = f2;` NON VALIDE - cast nécessaire

### Nous souhaitons créer une liste (type List<T>) pouvant contenir des cercles et des rectangles, est-ce possible ? Si oui, quel doit être le type de cette liste ?

Oui, `List<Figure>`

###  Nous souhaitons écrire une fonction qui à partir de la liste de la question précédente renvoie une table de correspondance (typeMap<TCle, TVal>) dont la clé correspondra à un genre de figure géométrique et la valeur associée au nombre d’occurrences de ce genre de figure dans la liste passée en paramètre. Proposez une implémentation de cette fonction.

