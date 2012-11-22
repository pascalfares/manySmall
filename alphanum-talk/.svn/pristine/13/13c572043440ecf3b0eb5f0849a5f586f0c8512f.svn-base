/*
 * Le processus client, Traitement des commandes client du talk conferences
 */
package talkclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketException;

import lb.edu.isae.GV;
import lb.edu.isae.tools.SoketSendReceiveUDP;

/**
 *
 * @author pfares
 */
public class TalkClient {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        SoketSendReceiveUDP socket = new SoketSendReceiveUDP(0);
        //PrintWriter pw  = new PrintWriter(System.out);
        if (GV.DEBUG) System.out.println("============");     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Thread t1 = new Thread(new InterpreteCommande(br, System.out, socket));
        t1.start();
        
        Thread t2 = new Thread(new interpreteSocketClient(socket));
        t2.start();
    }
}
