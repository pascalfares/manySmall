
/**
 * Si NoeudArbreN exite ng et nd != null
 * un element <x;null,null> est defini par
 * <x,AG,AD> ou AG.racine==null et AD.racine==null
 * ArbreB sont des références de NoeudArbreB
 * @author Pascal fares
 * $Log: ArbreB.java,v $
 * Revision 1.4  2001/05/24 09:42:44  pfares
 * Amélioration
 *
 * Revision 1.3  2001/05/24 09:33:32  pfares
 * Caml
 *
 * Revision 1.2  2001/05/20 15:53:11  pfares
 * Apres test
 *
 */
class NoeudArbreB implements java.io.Serializable{
    Noeud val;
    ArbreB ng; //Arbre gauche 
    ArbreB nd; //Arbre droit

    public Noeud getVal() { return val;}
    public void setVal(Noeud v) {val=v;}

    public NoeudArbreB (Noeud v, ArbreB g, ArbreB d) {
	val = v; ng=g; nd=d;
    }

    public String toString() {
	//interessant pour les expression arithmétique
	return "<"+val.toString()+","+ng.toString()+","+nd.toString()+">";
    }

    public ArbreB getNg() { return ng; }

    public ArbreB getNd() { return nd; }

    public void setNg(ArbreB g) { ng=g; }

    public void setNd(ArbreB d) { nd=d; }
}

/**
 *ArbreB référence de NoeudArbreB
 *Un arbre sans noeud a son atribut arbre==null
 */
public class ArbreB implements java.io.Serializable{
    NoeudArbreB arbre; //cette indirection permet de 
                       //travailler sur les référence

    public String toString() {
	if (arbre==null) return "";
	else return (arbre.toString());
    }

    public  NoeudArbreB getRacine() {return arbre;}

    public ArbreB () {arbre = null;}

    /**
     * une feulle = <x,AG(vide),AD(vide)>
     * A(vide) arbre dont la racine est null
     */
    public ArbreB(Noeud val) {
	arbre = new NoeudArbreB(val, new ArbreB(),new ArbreB());
    }

    public ArbreB( NoeudArbreB racine) {arbre=racine;}

    public ArbreB(Noeud v,ArbreB g, ArbreB d) {
		arbre = new NoeudArbreB(v, g, d);
    }

    public ArbreB arbreGauche() {
	return arbre.getNg();
    }

    public ArbreB arbreDroit() {
	return arbre.getNd();
    }
    public void setGauche(ArbreB g) {
	arbre.setNg(g);
    }

    public void setDroit(ArbreB d) {
	arbre.setNd(d);
    }
    /**
     * passage de <x,U,<y,V,W>> à <y,<x,U,V>,W>
     */
    public ArbreB rg() { //rotation gauche
	ArbreB auxdroit = arbreDroit();
        ArbreB gauchey = auxdroit.arbreGauche();//V
        arbre.setNd(gauchey); 
        auxdroit.setGauche(this);
        return auxdroit;
    }

    /**
     * passage de <x,<y,U,V>,W> à <y,U,<x,V,W>
     */
    
    public ArbreB rd() { //rotation droite
      	 ArbreB auxgauche = arbreGauche();
         ArbreB droitey = auxgauche.arbreDroit();//V
         arbre.setNg(droitey);
         auxgauche.setDroit(this);
         return auxgauche;
    }

    public void insert(Noeud n) {
        if (arbre==null) { //l'arbre est vide
            //création de la feuille dans une position vide
	    arbre = new NoeudArbreB(n,new ArbreB(),new ArbreB());
	}
	else {
	    if ((arbre.getVal()).comp(n) ==-1) { //racine <n
		//la position de n est à droite
		(arbre.getNd()).insert(n);
	    }
	    else (arbre.getNg()).insert(n);
	}
    }
     
    public ArbreB recherche(Noeud n) {
	ArbreB atrouve=null;
	int res;
	if (arbre == null) atrouve = null;
	else if ((res = (arbre.getVal()).comp(n)) == -1) {
	    atrouve = (arbreDroit()).recherche(n);
	}
	else if (res == 0) atrouve = this;
	else atrouve=(arbreGauche()).recherche(n);
	return atrouve;
    }

    public ArbreB recherchePG() {
        //ref.droite == this;
	//recherche du plus grand (c'est le neud n'ayant pas de droite)
        if ((arbre.getNd()).getRacine() == null) return this;
	else return (arbre.getNd()).recherchePG();

    }
    public ArbreB recherchePP() {
	//ref.gauche==this
	//recherche du plus grand (c'est le neud n'ayant pas de droite)
        if ((arbre.getNg()).getRacine() == null) return this;
	else return (arbre.getNg()).recherchePP();
    }
    public void suprimeNoeud() {
	if (arbreGauche().arbre == null) {
	    arbre = arbreDroit().arbre;
	}
	ArbreB pgg = (arbreGauche()).recherchePG();
	if (pgg !=null) {
	    arbre.setVal(pgg.arbre.getVal());
	    pgg.arbre = pgg.arbreGauche().arbre;
	}
	else {
	    //c'est vraiment pas normal!!!!
	}
    }
    public void suprime (Noeud n) {
	ArbreB rech = recherche(n);
        rech.suprimeNoeud();
		
    }
    
    
}
    
