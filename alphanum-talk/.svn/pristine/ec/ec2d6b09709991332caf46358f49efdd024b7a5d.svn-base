/*
 * Le Tokenizer par scanner et expressions régulières
 */
package lb.edu.isae.commandesTalk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author pfares
 */
public class CommandScanner {
    Scanner s;
    Pattern p;
    
    /**
     * La commande courante: dernier nextCommand
     */
    public Command currentCommand;
    public int nval;
    public String sval;
    
	public static enum Command {
		CONNECT,
		WHO,
		QUIT,
		KILL,
		SHUTDOWN,
                TEXTE,
                CHAINE,
                NOMBRE,
                ADRESSE,
		NOP
	}
    public CommandScanner(BufferedReader is){
    	s=new Scanner(is);
        p = Pattern.compile("_(connect|quit|who|shutdown|kill)");
    }
	private boolean hasNextCommand(){
		return s.hasNext(p);
	}
	public Command nextCommand() {
            if(hasNextCommand()){
		String res = s.next(p);
		if (res.equals("_connect")) return (currentCommand = Command.CONNECT);
		if (res.equals("_who")) return (currentCommand = Command.WHO);
		if (res.equals("_quit")) return (currentCommand = Command.QUIT);
		if (res.equals("_kill")) return (currentCommand = Command.KILL);
		if (res.equals("_shutdown")) return (currentCommand = Command.SHUTDOWN);
                return (currentCommand = Command.NOP); //Ne dvrait jamais arrivé! ECHEC
            } else {
                //Aucune commande donc ligne de texte à emettre ou rien!
            	if (s.hasNextLine()) {
                     sval = nextTexte();
		             return (currentCommand = Command.TEXTE);
            	} else return (currentCommand = Command.NOP);
            }
	}
	
	String nextTexte(){
		return s.nextLine();		
	}
	
	public Command nextSurnom() {
		if (s.hasNext()){
		sval= s.next();
                return (currentCommand = Command.CHAINE);
            }
                return (currentCommand = Command.NOP);
	}
	
	/**
	 * A modifier pour reconnaitre xxx.yyy.zzz.wwww
	 * @return l'adresse du serveur
	 */
	public Command nextAdresseServeur() {
            if (s.hasNext()){
		sval= s.next();
                return (currentCommand = Command.ADRESSE);
            }
            return (currentCommand = Command.NOP);
	}
	
	public Command nextPort(){
            if (s.hasNextInt()){ 
		nval= s.nextInt();
                return (currentCommand = Command.NOMBRE);
            }
            return (currentCommand = Command.NOP);
	}
	
        /**
         * Tests unitaires
         * @param s : pas utilisé
         */
	public static void main (String s[]){
		CommandScanner cs = new CommandScanner(new BufferedReader(new InputStreamReader(System.in)));
                
		while ((cs.nextCommand()) != Command.SHUTDOWN){
			System.out.println(cs.currentCommand);
			if (cs.currentCommand==Command.TEXTE) System.out.println(cs.sval);
                        else if (cs.currentCommand==Command.CONNECT) 
                        {   cs.nextSurnom();
                            System.out.append(cs.sval);
                            cs.nextCommand();
                        }
		}
	}
}
