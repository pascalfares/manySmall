/**
 *Les info de l'arbre doivent poss�der
 *la m�thode comp pour comparer deux �l�ments
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
