package Info;

public class Matiere {

    private int Nomatiere;
    private String cnam;
    private String intitule;

    public Matiere(int Nomatiere, String cnam, String intitule) {
        this.Nomatiere = Nomatiere;
        this.cnam = cnam;
        this.intitule = intitule;
    }

    public int getNomatiere() {
        return Nomatiere;
    }

    public void setNomatiere(int Nomatiere) {
        this.Nomatiere = Nomatiere;
    }

    public String getCnam() {
        return cnam;
    }

    public void setCnam(String cnam) {
        this.cnam = cnam;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
