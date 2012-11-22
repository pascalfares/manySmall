/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkServeur.langage;

import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.commandesTalk.CommandScanner.Command;

/**
 *
 * @author pfares
 */
public class CommandWho extends CommandServeur {
  
    public static CommandWho parse(CommandScanner cs) {
        System.out.println("Parse de who "+ cs.currentCommand);
        if (cs.currentCommand != Command.WHO) return null;
        //cs.nextCommand();        
        return new CommandWho();
    }
    
}
