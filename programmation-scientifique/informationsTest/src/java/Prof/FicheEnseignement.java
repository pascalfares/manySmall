package Prof;

public class FicheEnseignement {

    private int Nomatiere;
    private String cnam;
    private String intitule;
    private int semestre;
    private int IdCentre;
    private int NoGroupe;

    public FicheEnseignement(int Nomatiere, String cnam, String intitule, int semestre, int IdCentre, int NoGroupe) {
        this.Nomatiere = Nomatiere;
        this.cnam = cnam;
        this.intitule = intitule;
        this.semestre = semestre;
        this.IdCentre = IdCentre;
        this.NoGroupe = NoGroupe;
    }

    /**
     * @return the Nomatiere
     */
    public int getNomatiere() {
        return Nomatiere;
    }

    /**
     * @param Nomatiere the Nomatiere to set
     */
    public void setNomatiere(int Nomatiere) {
        this.Nomatiere = Nomatiere;
    }

    /**
     * @return the cnam
     */
    public String getCnam() {
        return cnam;
    }

    /**
     * @param cnam the cnam to set
     */
    public void setCnam(String cnam) {
        this.cnam = cnam;
    }

    /**
     * @return the intitule
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * @param intitule the intitule to set
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the IdCentre
     */
    public int getIdCentre() {
        return IdCentre;
    }

    /**
     * @param IdCentre the IdCentre to set
     */
    public void setIdCentre(int IdCentre) {
        this.IdCentre = IdCentre;
    }

    /**
     * @return the NoGroupe
     */
    public int getNoGroupe() {
        return NoGroupe;
    }

    /**
     * @param NoGroupe the NoGroupe to set
     */
    public void setNoGroupe(int NoGroupe) {
        this.NoGroupe = NoGroupe;
    }
}
