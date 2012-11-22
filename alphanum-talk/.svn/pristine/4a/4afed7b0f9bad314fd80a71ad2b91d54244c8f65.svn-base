/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkServeur.langage;

import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.commandesTalk.CommandScanner.Command;
import lb.edu.isae.tools.SoketSendReceiveUDP;

/**
 *
 * @author pfares
 */
public class CommandServeur {
    
    public void eval(SoketSendReceiveUDP mysock){
        System.out.println("Dans eval de "+this);
    }
        
    public static CommandServeur parse(CommandScanner cs){
        if (cs.currentCommand == Command.TEXTE) return CommandTexte.parse(cs);
        if (cs.currentCommand == Command.WHO) return CommandWho.parse(cs);
        if (cs.currentCommand == Command.KILL) return CommandKill.parse(cs);
        if (cs.currentCommand == Command.CONNECT) return CommandConnect.parse(cs);
        System.out.print("Echec du parse !");
        return null;
    }
    
}
