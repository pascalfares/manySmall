import java.net.*;

public class DayWatch {
    private DatagramSocket ds;
    private DatagramPacket dp;

    public static void main (String args[]) throws Exception {
	DayWatch d = new DayWatch();
	d.go();
    }

    public void go() throws Exception {
	byte [] buff = new byte[64];
	String s;
	ds= new DatagramSocket(DayBCast.DAYTIME_PORT);
	dp = new  DatagramPacket(buff,buff.length);
	for (;;) {
	    ds.receive(dp);
	    s =  new String(dp.getData());
	    System.out.println("Time reçu de " + dp.getAddress() + 
                     " est " + s);
	}
    }
}
