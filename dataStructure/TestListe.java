
/**
 * TestListe.java
 *
 *
 * Created: Fri Feb 23 09:43:34 2001
 *
 * @author Pascal Farès
 * @version
 */
import liste.ListeR;

public class TestListe  {
    
    public TestListe() {
	
    }
    public static void main(String a[]) {
	ListeR l = new ListeR();
	l.cons(new Integer(1));
	l.cons(new Double(2));
	l.cons("TOTO");
	System.out.println(l.toString());
    }
    
} // TestListe
