/*
 * Client.java
 *
 * Created on 10 janvier 2003, 14:05
 */

package RCB1.listeclient;

/**
 *
 * @author  pfares
 */
public class Client implements java.io.Serializable {
    
    private java.net.InetAddress address;
    
    private int port;
    
    /** Creates a new instance of Client */
    public Client(java.net.InetAddress a, int p) {
        address=a; port=p;
    }
    public boolean is(java.net.InetAddress a, int p) {
        return (address.equals(a) && (port==p));
    }
    public String toString() {
        return "("+address.getHostAddress()+":"+port+")";
    }
    public java.net.InetAddress getAddress() { 
        return address;
    }
    public int getPort() {
        return port;
    }
}
