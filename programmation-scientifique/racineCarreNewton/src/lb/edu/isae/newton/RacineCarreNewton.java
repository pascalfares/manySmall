package lb.edu.isae.newton;
/**
 * Calcul de la racine carrée méthode newton
 * @author pascalfares
 *
 */
public class RacineCarreNewton {
	/**
	 * 
	 * @param a calcul de la racine carré de a
	 * @param error erreur relative
	 * @return racine carré de a à error près.
	 */
    public static double rc(double a, double error) {
    	//X0=A
    	//Xn
    	double Xn=a;
    	//Xn+1
    	double RC=a;
    	//Xn+1-Xn/xn l'erreur relative
    	double pas = a;
    	while (pas > error){
    		//Xn+1=1/2(Xn+A/Xn) : newton
    		RC = 0.5*(RC+(a/RC));
    		pas = (Xn-RC)/Xn;
    		Xn=RC;
    		System.out.println("pas="+pas+" racine="+RC);
    	}
    	return RC;
    }
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(rc(25.0,0.0000001));
		System.out.println(rc(100.0,0.0000001));
		System.out.println(rc(6.0,0.0000001));

	}

}
