/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lb.edu.isae.entity;

import java.net.InetAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author pfares
 */
public class ListeClient {
    HashMap<String, Client> lc;
    
    
    public ListeClient(){
        lc = new HashMap<String, Client>();
    }
    
    // TODO traiter le cas des duplications de noms
    public void add(String nomClient, InetAddress a, int p) {
        lc.put(nomClient, new Client(a,p));
    }
    public Client cherche(String nomClient){
        return lc.get(nomClient);
    }
    public void remove (String nomClient){
        lc.remove(nomClient);
    }
    
    /**
     * 
     * @return la liste des host client 
     */
    public Collection<Client> getListeClient() {
        return lc.values();
    }
    
    /**
     * 
     * @return la liste des surnam des clients talk
     */
    public Set<String> getListeSurnom() {
        return lc.keySet();
    }
}
