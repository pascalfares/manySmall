/*
 * ChatClient.java
 *
 * Created on 8 janvier 2003, 13:19
 */

package RCB1.minichat;

import java.io.*;
import java.net.*;

/**
 *
 * @author  pfares
 */
class GetMessage extends Thread {
    int port;
    
    /**
     * Adressse Inet du serveur de chat
     */
    InetAddress adress;
    /**
     * Socket d'echage avec le serveur
     */
    DatagramSocket socket;
    
    byte[] buffer;
    /** Le thread de lecture de la socket qui a envoyé au serveur
     * @param ad adresse internet serveur
     * @param s socket de communication avec le serveur
     * @param p port du serveur
     */    
    public GetMessage(InetAddress ad, DatagramSocket s, int p) {
        port =p;
        adress=ad;
        socket =s;
        buffer = new byte[1024];
        start();
    }
    /** La boucle infinie du thread
     */    
    public void run()  {
        String line;
        for(;;) {
            try {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            line=new String(buffer);
            System.out.println(line);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
    
class GetText extends Thread {
    int port;
    
    /**
     * Adressse Inet du serveur de chat
     */
    InetAddress adress;
    /**
     * Socket d'echage avec le serveur
     */
    DatagramSocket socket;
    
    byte[] buffer;
    /** Initialisation de la lecture du clavier
     * @param ad adresse internet du serveur
     * @param s la socket de communication avec le serveur
     * @param p le Port du serveyr
     */    
    public GetText(InetAddress ad, DatagramSocket s, int p) {
        port =p;
        adress=ad;
        socket =s;
        buffer = new byte[1024];
        start();
    }
    /** Lecture du clavier envoi du paquet
     */    
    public void run() {
        String line;
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        for(;;) {
            try {
            line=br.readLine();
            buffer=line.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, line.length(), adress,port);
            socket.send(packet);
            }
            catch (Exception e) {}
   
        }
    }
}   
    
/** La classe du client
 */
public class ChatClient {
    /**
     * Le port par defaut du serveur de chating
     */
    static final int port=6010;
    
    /**
     * Adressse Inet du serveur de chat
     */
    static InetAddress address;
    /**
     * Socket d'echage avec le serveur
     */
    static DatagramSocket socket;
    
    /** Creates a new instance of ChatClient */
    public ChatClient() {
    }
    
    /** Lancement des 2 threads lecture clavier lecture socket
     * @param args the command line arguments
     * @throws Exception Pour simplifier
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java ChatClient <adresse du serveur>");
        }
        else {
            
            address = InetAddress.getByName(args[0]);
            socket = new DatagramSocket();
            new GetMessage(address, socket, port);
            new GetText(address, socket, port);
        }        
        
    }
    
}
