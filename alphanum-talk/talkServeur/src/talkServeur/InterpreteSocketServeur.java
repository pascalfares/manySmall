/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkServeur;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import lb.edu.isae.GV;
import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.tools.SoketSendReceiveUDP;
import talkServeur.langage.CommandServeur;

/**
 *
 * @author pfares
 */
public class InterpreteSocketServeur implements Runnable {
    SoketSendReceiveUDP socket;
 
    public InterpreteSocketServeur(SoketSendReceiveUDP s){
        socket = s;
    }
    public void run() {
        try {
            
            for(;;) {
                BufferedReader s = socket.receive();
                //Chaque ligne rećut est scannée
                CommandScanner sc = new CommandScanner(s);
                sc.nextCommand();
                CommandServeur comm = CommandServeur.parse(sc);
                if (comm != null) comm.eval(socket);
                else if (GV.DEBUG) System.out.println("ligne vide pourquoi?");
        }
        } catch (SocketException ex) {
            Logger.getLogger(InterpreteSocketServeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterpreteSocketServeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
