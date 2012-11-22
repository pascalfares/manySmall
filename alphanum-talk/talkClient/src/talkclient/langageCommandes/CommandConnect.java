/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package talkclient.langageCommandes;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lb.edu.isae.commandesTalk.CommandScanner;
import lb.edu.isae.commandesTalk.CommandScanner.Command;
import lb.edu.isae.entity.Client;
import lb.edu.isae.tools.SoketSendReceiveUDP;

/**
 *
 * @author pfares
 */
public class CommandConnect extends CommandClient {

    /**
     * @return le serveur
     */
    public static Client getServeur() {
        return serveur;
    }
    String surnom;
    
    //host:port est un client au sens host
    //String host;
    //int port;
    private static Client serveur=null;
    @Override
    public String toString() {
        return "CONNECT "+surnom+"@"+getServeur();
    }
   
    public CommandConnect(String n, String h, int p) throws UnknownHostException{
        surnom = n;
        //host = h;
        //port=p;
        serveur= new Client(h,p);
    }
    
    @Override
    public void eval(SoketSendReceiveUDP s) {
        System.out.println("Dans Connect eval de "+this);
        try {
            if (s!=null) s.send("_connect "+surnom, getServeur());
            else System.out.println("O O");
        } catch (IOException ex) {
            Logger.getLogger(CommandConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Dans Connect eval de "+this+" tout va bien!");
    }
    public static CommandConnect parse(CommandScanner cs){
        if (cs.currentCommand != Command.CONNECT) return null;
        System.out.println("dans le parse "+cs.currentCommand);
        if (cs.nextSurnom() != Command.CHAINE) return null;
        String n = cs.sval;
        System.out.println("dans le parse "+cs.currentCommand);
        if (cs.nextAdresseServeur() != Command.ADRESSE) return null;
        String a = cs.sval;
        System.out.println("dans le parse "+cs.currentCommand);
        if (cs.nextPort() != Command.NOMBRE) return null;
        int p = cs.nval;
        System.out.println("dans le parse "+cs.currentCommand);
        try {
            //cs.nextCommand(); //on skip le nombre (sera fait par le wile du run
            return new CommandConnect(n,a,p);
        } catch (UnknownHostException ex) {
            Logger.getLogger(CommandConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
