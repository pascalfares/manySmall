/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkclient.langageCommandes;

import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.commandesTalk.CommandScanner.Command;
import lb.edu.isae.tools.SoketSendReceiveUDP;

/**
 *
 * @author pfares
 */
public abstract class CommandClient {
    
    public void eval(SoketSendReceiveUDP s) {
        System.out.println("Dans eval de "+this);
    }
    //evaluation de commande clavier
    public void eval_clavier(SoketSendReceiveUDP s) {
        eval(s);
    }
    //Evaluation commande socket
    public void eval_socket(SoketSendReceiveUDP s) {
        eval(s);
    }
    
    public static CommandClient parse(CommandScanner cs){
        System.out.println("Dans parse Global "+cs.currentCommand);
        if (cs.currentCommand == Command.CONNECT) return CommandConnect.parse(cs);
        if (cs.currentCommand == Command.WHO) return CommandWho.parse(cs);
        if (cs.currentCommand == Command.TEXTE) return CommandTexte.parse(cs);
        System.out.println("Dans fin parse Global ECHEC"+cs.currentCommand);
        return null;
    }
    
}
