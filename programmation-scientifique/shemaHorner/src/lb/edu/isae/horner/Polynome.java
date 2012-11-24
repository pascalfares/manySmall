/**
 * 
 */
package lb.edu.isae.horner;

import java.util.ArrayList;

/**
 * @author pascalfares
 * Modélisation d'un polynome P(X) de degré n
 */
public class Polynome {
	private int degre;
	/**
	 * @return the degre
	 */
	public int getDegre() {
		return degre;
	}
	/**
	 * @param degre the degre to set
	 */
	public void setDegre(int degre) {
		this.degre = degre;
	}

	private ArrayList<Double> coefs;
	
    public Polynome(int degre){
    	coefs=new ArrayList<Double>(degre+1);
    	this.degre=degre;
    }
	/**
	 * @return the coefs
	 */
	public ArrayList<Double> getCoefs() {
		return coefs;
	}
	public double getCoefs(int i) {
		return coefs.get(i);
	}
	/**
	 * @param coefs the coefs to set
	 */
	public void setCoefs(double dcoefs[]) throws Exception {
		// de zero à degre degre+1 elements
		if (dcoefs.length != (degre+1)) throw new Exception("Mauvaise taille!");
		for(int i=0; i<= degre; i++) {
			coefs.add(i, dcoefs[i]);
		}
	}
	//Affichage du polynome au format aiX^(n-i)
	public String toString() {
		String res="P(X)=";
		for (int i=0; i<degre; i++){
			res += coefs.get(i)+"X^"+(degre-i)+"+";
		}
		//reste le dernier
		res+=coefs.get(degre);
		return res;
	}
	
	//Pour test unitaire
	public static void main(String a[]){
		double poly[]={1.0,3.0,5.0,-1.0,15};
		//degre 4
		Polynome p = new Polynome(4);
		try {
			p.setCoefs(poly);
			System.out.println(p);
		} catch (Exception e) {
			System.out.println("Problème de taille");
		}
	}
}
