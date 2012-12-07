						
import java.io.*;
import java.net.*;

public class DayTimeClient{

   public static final int port = 13;
   public static void main(String args[])
   {
      Socket s = null;
      String timestamp;
      try
      {
         // <p> Création de la socket
         s = new Socket(args[0], port);
         // creation de l'imput stream
         InputStream in = s.getInputStream();
         BufferedReader bin =
            new BufferedReader(new InputStreamReader(in));
         // Informer l'utilisateur
         System.out.println("Connecté à : " +
            s.getInetAddress() + " port " + s.getPort()) ;
         while (true) {
            // lire le réseau 
            timestamp = bin.readLine();
            if (timestamp == null) {
              System.out.println("Connextion stopée");
              break;
            }
            System.out.println("Daytime : " + timestamp);
         }
      }
      catch (IOException e) { System.out.println(e);}
      finally
      {
          //forcer la fermeture de la connexion
          try
            { if (s != null) s.close(); }
          catch (IOException e2)
              { }
      }
   }
}
						
					
