class MesObjets implements Noeud {
    int v;
    public MesObjets(int a) {v=a;}
    public int comp(Noeud n) {
	MesObjets ob = (MesObjets) n;
	if (v < ob.v) return -1;
	else if (v==ob.v) return 0;
	else return +1;
    }
    public String toString() {
	return ("Int:"+v);
    }
}
public class TestArbreB {
    public static void main(String args[]) {
	ArbreB a=new ArbreB();
	
        a.insert(new MesObjets(10));
	System.out.println("Insert 10 "+a);
		 
	a.insert(new MesObjets(5));	System.out.println("Insert 5 "+a);
	a.insert(new MesObjets(15));	System.out.println("Insert 15 "+a);
	a.insert(new MesObjets(4));	System.out.println("Insert 4 "+a);
	a.insert(new MesObjets(6));	System.out.println("Insert 6 "+a);
        a=a.rd();
       System.out.println("Rotation droite "+a);
       a=a.rg();
         System.out.println("Rotation gauche "+a);
	 System.out.println("Plus Grand"+a.recherchePG());
	 System.out.println("le vrai Plus Grand"+(a.recherchePG()).arbreDroit());
         ArbreB b;
	 System.out.println("recherche 5 "+(b=a.recherche(new MesObjets(5))));
         System.out.println("Plus grand a gauche de 5 "+(b.arbreGauche()).recherchePG());
         a.suprimeNoeud();
	 System.out.println("Suprime Noeud " + a);
         a.suprime(new MesObjets(5));
	 System.out.println("Suprime 5 " + a);
			    }
}
