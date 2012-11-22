/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkclient;

import talkclient.langageCommandes.CommandClient;
import java.io.BufferedReader;
import java.io.PrintStream;
import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.commandesTalk.CommandScanner.Command;
import lb.edu.isae.tools.SoketSendReceiveUDP;

/**
 *
 * @author pfares
 */
public class InterpreteCommande implements Runnable {
    CommandScanner cs;
    PrintStream os;
    SoketSendReceiveUDP socket;
    public InterpreteCommande (BufferedReader is, PrintStream os, SoketSendReceiveUDP so){
        cs = new CommandScanner(is);
        this.os=os;
        socket=so;
    }
    @Override
    public void run () {
        
        CommandClient cc;
        os.println("avant");
        while (cs.nextCommand() != Command.QUIT) {
            //os.println("debut de boucle");
            cc = CommandClient.parse(cs);
            os.println(cc);
            try { 
                if (cc != null) cc.eval_clavier(socket);
            } catch (UnsupportedOperationException e){
                System.out.println("Pas encore de eval"+ e);
                
            }
 
        }
    }
}
