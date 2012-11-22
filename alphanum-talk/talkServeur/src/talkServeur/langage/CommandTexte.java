/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkServeur.langage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.commandesTalk.CommandScanner.Command;
import lb.edu.isae.entity.Client;
import lb.edu.isae.tools.SoketSendReceiveUDP;
import talkServeur.TalkServeur;

/**
 *
 * @author pfares
 */
public class CommandTexte extends CommandServeur {
    String message;
    
    @Override
    public String toString() {
        return "TEXTE :"+message;
    }
    @Override
    public void eval(SoketSendReceiveUDP mysock) {
        //TODO que faire dans le cas d'un texte saisie coté serveur sur le terminal?
        if (mysock == null) return; //Do nothing
        for (Client c: TalkServeur.listeClient.getListeClient()){
            try {
                mysock.send(message, c);
            } catch (IOException ex) {
                Logger.getLogger(CommandConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    CommandTexte(String s){
        message = s;
    }
    
    public static CommandTexte parse(CommandScanner sc){
        if (sc.currentCommand != Command.TEXTE) return null;
        String s = sc.sval;
        //sc.nextCommand();
        return new CommandTexte(s);
    } 
}
