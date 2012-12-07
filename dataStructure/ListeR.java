package liste;

import java.io.*;

/**
 *Noeud : Le noued d'un élément de Liste récursive simple
 */
class Noeud {
    Object v;
    Noeud suiv;
    /**
     *Constructeur connaissant l'élément seul
     */
    public Noeud(Object o) {
	v=o;
	suiv=null;
    }
    /**
     *constructeur connaisant la valeuyr et le suivant
     */
    public Noeud(Object o, Noeud suiv) {
	v=o;
	this.suiv=suiv;
    }
    /**
     *récupérer la valeur
     */
    public Object getV() {
	return (v);
    }
    /**
     *récupérer le suivant
     */
    public Noeud getSuiv() {
	return suiv;
    }
}

/**
 *La liste récursive
 */
public class ListeR {
    Noeud debut;
    public ListeR() {
	debut=null;
    }
    public ListeR cons (Object o) {
	debut=new Noeud(o, debut);
        return (this);
    }
    public Object car () {
	return (debut.getV());
    }
    public ListeR cdr () {
	debut=debut.suiv;
	return this;
    }
    public String toString() {
	Noeud courant=debut;
	String res="(";
	while (courant!=null) {
	    res=res+(courant.getV()).toString();
            courant=courant.getSuiv();
	}
	res += ")";
	return res;
    }
}
