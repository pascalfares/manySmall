/*
 * ListeClient.java
 *
 * Created on 10 janvier 2003, 13:56
 */

package RCB1.listeclient;

/**
 *
 * @author  pfares
 */
class DoubletClient {
    Client val;
    ListeClient suivant;
    
    /** Constructeur de doublet vide
     */    
    public DoubletClient () {
        val=null; suivant=null;
    }
    /** Constructeur de doublet
     * @param c Le client tete du doublet
     * @param lc Le reste de la liste
     */    
    public DoubletClient (Client c, ListeClient lc) {
        val=c; suivant=lc;
    }
    Client getVal() { return val; }
    void setVal(Client c) { val=c; }
    void setSuiv(ListeClient lc) {
        suivant=lc;
    }
    ListeClient getSuiv() {
        return suivant;
    }
   
}
    
/** La liste des clients.
 */
public class ListeClient implements java.io.Serializable{
    DoubletClient prem;
    
    /** Nouvelle instance vide de ListeClient
     */
    public ListeClient() {
        prem=null;
    }
    /** Création de la liste connaissant le doublet de départ
     * @param dc doublet de début
     */    
    public ListeClient(DoubletClient dc) {
        prem=dc;
    }
    /** Test si la liste est vide
     * @return True si liste vide false sinon
     */    
    public boolean listeVide() {
        if (prem==null) return true;
        else return false;
    }
    /** Le premier client de la liste
     * @return Le premier client de la liste
     */    
    public Client prem() {
        return prem.getVal();
    }
    /** Le reste de la liste ( sans la tete) Une liste = (tête . reste)
     * @return Le reste de la liste
     */    
    public ListeClient suiv() {
        return prem.getSuiv();
    }
    ListeClient _recherche (java.net.InetAddress a, int p) {
        if ((prem==null) || prem().is(a,p)) return this;
        else return suiv()._recherche(a,p);
    }
    Client recherche(java.net.InetAddress a, int p) {
        return _recherche(a,p).prem();
    }
    /** Ajout d'un client
     * @param a Adresse internet
     * @param p les port du client
     */    
    public void ajouter(java.net.InetAddress a, int p) {
        if (_recherche(a,p).listeVide()) {
            ListeClient lc= new ListeClient(prem);
            prem=new DoubletClient(new Client(a,p), lc);
        }
    }
    /** Supression d'un client
     * @param a Adresse internet
     * @param p les port du client
     */    
    public void suprimer(java.net.InetAddress a, int p) {
        ListeClient lc = _recherche(a,p);
        if (!lc.listeVide()) {
            prem=suiv().prem;
        }
    }
    /** La representation de la liste
     */    
    public String toString() {
        String s;
        if (listeVide()) return "";
        else return prem().toString()+suiv().toString();
    }
    
    /** Progrtamme de Test
     * @exception Exception toutes les erreurs a l'appelant
     * @param a Paramètre de la ligne de commande
     */
    public static void main (String a[]) throws Exception {
        ListeClient lc = new ListeClient();
        System.out.println(lc);
        lc.ajouter(java.net.InetAddress.getByName("192.168.1.12"), 10);
         System.out.println(lc);
        lc.ajouter(java.net.InetAddress.getByName("192.168.1.12"), 11);
         System.out.println(lc);
        lc.ajouter(java.net.InetAddress.getByName("192.168.1.1"), 10);
         System.out.println(lc);
         lc.suprimer(java.net.InetAddress.getByName("192.168.1.1"), 10);
         System.out.println(lc);
    }
        
}
