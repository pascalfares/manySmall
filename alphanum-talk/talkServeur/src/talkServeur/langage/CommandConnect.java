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
/**
 * Le connect reću coté serveur contient uniquement le surnom
 * CONNECT => _connect surnom
 * @author pfares
 */
public class CommandConnect extends CommandServeur {
    /**
     * Le surnom du client qui nous contact
     */
    String surnom;
    
    public CommandConnect(String s){
        surnom = s;
    }
    
    @Override
    public void eval(SoketSendReceiveUDP mysock) {
        if (mysock == null) return; //Do nothing it is an error in fact!
        TalkServeur.listeClient.add(surnom, mysock.getAddress(), mysock.getPort());
        for (Client c: TalkServeur.listeClient.getListeClient()){
            try {
                mysock.send(surnom, c);
            } catch (IOException ex) {
                Logger.getLogger(CommandConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static CommandConnect parse (CommandScanner sc){
        if (sc.currentCommand != Command.CONNECT) return null;
        if (sc.nextSurnom() == Command.NOP) return null;
        System.out.println("Connect de ? "+sc.sval);
        return new CommandConnect(sc.sval);
  
    }
    
}
