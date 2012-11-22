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
public class CommandKill extends CommandServeur {
    /** Surnom du client qu'on kill! */ 
    String surnom;
    public CommandKill(String s){
        surnom = new String(s);
    }
    @Override
    public void eval(SoketSendReceiveUDP mysock) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static CommandKill parse(CommandScanner sc){
        if (sc.currentCommand != Command.KILL) return null;
        if (sc.nextSurnom() != Command.CHAINE) return null;
        //sc.nextCommand();
        return (new CommandKill(sc.sval));
    }
    
    
}
