package lb.edu.isae.horner;

public class CalculPX {
	Polynome p;

	public CalculPX(double dcoefs[]) throws Exception {
		int degre = dcoefs.length - 1;
		p = new Polynome(degre);
		p.setCoefs(dcoefs);
	}

	public double valeurde(double X) {
		double P = p.getCoefs(0); // b0
		for (int i = 1; i <= p.getDegre(); i++) {
			// bi=bi-1X+ai
			P = P * X + p.getCoefs(i);
		}
		return P;
	}

	/**
	 * Calcul de la valeur d'un polynome en un point x (recursif) p(x) = a0 +
	 * a1.x+....+ap.xp = a0 + x(a1+a2.x+....+ap.xp-1) [a0,..,ap](x) =
	 * a0+x[a1,..,ap] 
	 * Ou selon notre modélisation du polynome
	 * Pn(X)=a0Xn+....+an-iXi+......+an =an+x[a0...an-1]
	 * P0(X)=a0
	 * p2(X)=a0X2+a1X1+a2=x(a0X+a1)+a2=XP1(X)+a2
	 * Pdegre(X)=a0Xdegre+......+adegre=adegre+X(Pdegre-1(X))
	 * @param polynome
	 *            : Les coeficients du polynome p(x) = a0 + a1.x+....+ap.xp
	 * @param x
	 *            : la valeur du point
	 * @return P(x)
	 */
	public double eval(int degre, double x) {
		if (degre == 0)
			return p.getCoefs(0);
		else
			return p.getCoefs(degre) + x * eval(degre - 1, x);
	}

	/**
	 * @return the p
	 */
	public Polynome getP() {
		return p;
	}

	/**
	 * @param p
	 *            the p to set
	 */
	public void setP(Polynome p) {
		this.p = p;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		double p1[] = { 1.0, 1.0, 1.0 };
		double p2[] = { 2.0, 3.0, 4.0 };
		CalculPX P1 = new CalculPX(p1);
		CalculPX P2 = new CalculPX(p2);
		System.out.println(P1.getP() + "(2)=" + P1.valeurde(2));
		System.out.println(P2.getP() + "(3)=" + P2.valeurde(3));
		System.out.println(P1.getP() + "(2)=" + P1.eval(P1.getP().getDegre(),2));
		System.out.println(P2.getP() + "(3)=" + P2.eval(P2.getP().getDegre(),3));
	}

}
