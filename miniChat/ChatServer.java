/*
 * ChatServer.java
 *
 * Created on 8 janvier 2003, 14:08
 */

package RCB1.minichat;

import java.io.*;
import java.net.*;
import RCB1.listeclient.*;

/** Le serveur qui gère les connexion des clients; Il reçoit
 * l'identifiant d'un client (ip,port) et l'ajoute a la liste des clients connéctés.
 * Quand on reçoit un message il est envoyé a tous les clients connus
 * @author Pascal Farès
 * @version 0.1
 * @see ChatClient
 */
public class ChatServer {
    /**
     * Le port par defaut du serveur de chating
     */
    static final int port=6010;
    
    /** Creation d'un nouvelle instance de  ChatServer
     */
    public ChatServer() {
    }
    
    /**
     * @param args Les arguments de la ligne de commande
     */
    public static void main(String[] args) throws Exception {
        ListeClient lc = new ListeClient();
        byte buffer[] = new byte[1024];
        DatagramSocket socket = new DatagramSocket(port);
        /**
         * Ici lengthcode n'est pas encore términé il faut
         * Ajouter la gestion de la liste des clients
         * et l'envoie du message a tous les clients connu
         */
        
        for(;;) {
            
            DatagramPacket packetr=new DatagramPacket(buffer,buffer.length);
            socket.receive(packetr);
            System.out.println(new String(buffer));
            lc.ajouter(packetr.getAddress(), packetr.getPort());
            System.out.println(lc);
            
            for (ListeClient lcn=lc; !lcn.listeVide(); lcn=lcn.suiv()) {
                
                DatagramPacket packete=new DatagramPacket(buffer,buffer.length, 
                lcn.prem().getAddress(), lcn.prem().getPort());
                socket.send(packete);
            }
        }
        
    }
    
}
