import java.net.*;
import java.util.*;

public class DayBCast {
    DatagramSocket ds;
    DatagramPacket dp;
    InetAddress addr;

    public static final int DAYTIME_PORT = 5353;

    public static void main(String args[]) throws Exception {
	DayBCast db = new DayBCast(args[0]);
        db.go();
    }

    public DayBCast(String target) throws Exception {
	addr = InetAddress.getByName(target);
	ds = new DatagramSocket();
    }


    public void go() throws Exception {
	byte [] buff;
	for (;;) {
	    Thread.sleep(1000);
	    System.out.println("Sending");
	    String s = (new Date()).toString();
	    buff = s.getBytes();
	    dp = new DatagramPacket(buff,buff.length,addr, DAYTIME_PORT);
	    ds.send(dp);
	}
    }
}
