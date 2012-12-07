/**
 *Les info de l'arbre doivent posséder
 *la méthode comp pour comparer deux éléments
 */

public interface Noeud extends java.io.Serializable {
    /**
     * retour:
     * -1 => this < n
     * 0 => this == n
     * +1 => this > n
     */
    public int comp(Noeud n);
}
