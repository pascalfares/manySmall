/*
 * SoketSendReceiveUDP permet d'encapsuler les emission et reception dans
 * le cadre de socket UDP
 */
package lb.edu.isae.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.Charset;

import lb.edu.isae.GV;
import lb.edu.isae.entity.Client;

/**
 *
 * @author pfares
 * @version $*
 */
public class SoketSendReceiveUDP {
    byte buffer[] = new byte[1024];
    /*
     * Le port par defaut
     */
    public static final int port=1111;
    DatagramPacket packetr= new DatagramPacket(buffer,buffer.length);
    DatagramSocket s;
    Charset csutf8= Charset.forName("UTF8");
    public SoketSendReceiveUDP () throws SocketException {
        s = new DatagramSocket(port);
    }
    public SoketSendReceiveUDP (int p) throws SocketException {
        if (p==0) s=new DatagramSocket();
        else s = new DatagramSocket(p);
    }
    
    /**
     * La reception des messages
     * @return Un BufferedReader à partir du packet reçut
     * @throws IOException
     */
    public BufferedReader receive() throws IOException{      
       s.receive(packetr);
       if (GV.DEBUG) System.out.println("Taille reçue " + packetr.getLength());
       return new BufferedReader(new StringReader(new String(buffer,0,packetr.getLength(),csutf8)));            
    }
    
    /** Adresse du peer,
     * 
     * @return l'adresse du peer qui a renvoyé le packet
     */
    public InetAddress getAddress() {
        return packetr.getAddress();
    }
    /**
     * 
     * @return port du peer 
     */
    public int getPort(){
        return packetr.getPort();
    }
    
    /**
     * 
     * @param s : la chaine à transmettre
     * @param c : Le client EN FAIT c'EST LE PEER l'autre hote
     * @throws IOException 
     */
    //TODO changer le nom de la classe Client en Host
    public void send(String s, Client c) throws IOException{
        DatagramPacket packets = new DatagramPacket (s.getBytes(),s.length(),c.getA(),c.getPort());
        this.s.send(packets);
    }
    
}
