/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.tools.SoketSendReceiveUDP;
import talkclient.langageCommandes.CommandClient;

/**
 *
 * @author pfares
 */
public class interpreteSocketClient implements Runnable {
    SoketSendReceiveUDP socket;
    public interpreteSocketClient(SoketSendReceiveUDP s){
        socket=s;
    }
    public void run() {
        {
            BufferedReader br = null;
            try {
                //SoketSendReceiveUDP socket = new SoketSendReceiveUDP();
                for (;;) {
                    br = socket.receive();
                    CommandScanner sc = new CommandScanner(br);
                    sc.nextCommand();
                    CommandClient comm = CommandClient.parse(sc);
                    comm.eval_socket(socket);
                }
            } catch (SocketException ex) {
                Logger.getLogger(interpreteSocketClient.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex) {
               Logger.getLogger(interpreteSocketClient.class.getName()).log(Level.SEVERE, null, ex);
           } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(interpreteSocketClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         
    }
}
