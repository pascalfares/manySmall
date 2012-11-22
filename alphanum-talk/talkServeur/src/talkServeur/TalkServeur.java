/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkServeur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketException;
import lb.edu.isae.entity.ListeClient;
import lb.edu.isae.tools.SoketSendReceiveUDP;

/**
 *
 * @author pfares
 */
public class TalkServeur {
    
    /** La liste des clients et la socket est l'environnement (l'état)
     *  du langage
     */
    public static final ListeClient listeClient = new ListeClient();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        SoketSendReceiveUDP socket = new SoketSendReceiveUDP();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Le thread du traitement du clavier
        Thread t1 = new Thread(new InterpreteKeyServeur(br, System.out, socket));
        t1.start();
        
        //Le thread de traitement des sockets
        Thread t2 = new Thread(new InterpreteSocketServeur(socket));
        t2.start();      
    }
}
