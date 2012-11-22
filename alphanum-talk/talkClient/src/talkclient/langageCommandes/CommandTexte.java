/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkclient.langageCommandes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.commandesTalk.CommandScanner.Command;
import lb.edu.isae.tools.SoketSendReceiveUDP;

/**
 *
 * @author pfares
 */
public class CommandTexte extends CommandClient {
    String message;
    
    @Override
    public String toString() {
        return "TEXTE :"+message;
    }
   
    
    @Override
    public void eval_clavier(SoketSendReceiveUDP s){
        try {
            s.send(message,CommandConnect.getServeur());
        } catch (IOException ex) {
            Logger.getLogger(CommandTexte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
     public void eval_socket(SoketSendReceiveUDP s) {
        System.out.println(message);
    }
    CommandTexte(String s){
        message = s;
    }
    public static CommandTexte parse(CommandScanner sc){
        if (sc.currentCommand != Command.TEXTE) return null;
        String s = sc.sval;
        //sc.nextCommand(); sera fait par le while du run 
        return new CommandTexte(s);
    } 
    
}
