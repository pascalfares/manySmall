/**
 * Exponentielle methode Taylor
 */
package lb.edu.isae.Tylor;

/**
 * @author pascalfares
 * 
 */
public class E {
	/**
	 * Calcul de l'exponentielle (népérien) par Taylor
	 * 
	 * @param error
	 * @return l'exponetielle
	 */
	public static double e(double error) {

		int n = 0;

		// calcul factorielle n!
		long factorielle = 1;

		// exp = sigma(1/n!) : 0 <= n <= infini
		double exp = 1.0;

		// pas=(1/n!)
		double pas = 1.0;

		// exp=1, factorielle =1, n=0; pas = 1/0!
		while (pas > error) { // tanque 1/n! > error continuer
			n++;
			factorielle *= n;
			pas = (1.0 / factorielle);
			System.out.println("n=" + n + " pas= " + pas + " fcatorielle="
					+ factorielle);
			exp += pas;
		}
		return exp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(e(0.0000001));

	}

}
