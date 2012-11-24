package Etud;

public class FicheEtudiant {

    private int Nomatiere;
    private String cnam;
    private String intitule;
    private int semestre;
    private int IdCentre;
    private int payee;
    private int dispense;

    public FicheEtudiant(int Nomatiere, String cnam, String intitule, int semestre, int IdCentre, int payee, int dispense) {
        this.Nomatiere = Nomatiere;
        this.cnam = cnam;
        this.intitule = intitule;
        this.semestre = semestre;
        this.IdCentre = IdCentre;
        this.payee = payee;
        this.dispense = dispense;
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
     * @return the payee
     */
    public int getPayee() {
        return payee;
    }

    /**
     * @param payee the payee to set
     */
    public void setPayee(int payee) {
        this.payee = payee;
    }

    /**
     * @return the dispense
     */
    public int getDispense() {
        return dispense;
    }

    /**
     * @param dispense the dispense to set
     */
    public void setDispense(int dispense) {
        this.dispense = dispense;
    }
}
