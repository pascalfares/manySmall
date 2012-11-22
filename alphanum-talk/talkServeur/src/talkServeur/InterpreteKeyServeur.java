/*
 * Talk Serveur.
 * L'interpreteur / serveur de talk
 */
package talkServeur;

import java.io.BufferedReader;
import java.io.PrintStream;

import lb.edu.isae.GV;
import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.commandesTalk.CommandScanner.Command;
import lb.edu.isae.tools.SoketSendReceiveUDP;
import talkServeur.langage.CommandServeur;

/**
 *
 * @author pfares
 * @version $*
 */
public class InterpreteKeyServeur implements Runnable {
    CommandScanner cs;
    PrintStream os;
    SoketSendReceiveUDP socket;
 
    
    public InterpreteKeyServeur (BufferedReader is, PrintStream os, SoketSendReceiveUDP s){
        cs = new CommandScanner(is);
        this.os=os;
        socket =s;
    }
    @Override
    public void run () {
        CommandServeur cc;
        if (GV.DEBUG) os.println("avant");
        while (cs.nextCommand() != Command.SHUTDOWN) {
            //os.println("debut de boucle");
            cc = CommandServeur.parse(cs);
            if (GV.DEBUG) os.println(cc);
            try { 
                if (cc != null) cc.eval(socket);
            } catch (UnsupportedOperationException e){
                System.out.println("Pas encore de eval"+ e);
                
            }
 
        }
    }
}
