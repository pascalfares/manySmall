package Prof;

public class Professeur {

    private int numprof;
    private String nomprof;
    private String prenomprof;
    private String telp;
    private String mobilep;
    private String emailp;
    private int IdCentre;
    private int Nomatiere;
    private String intitule;
    private int NoChef;

    public Professeur(int numprof, String nomprof, String prenomprof, String telp, String mobilep, String emailp, int IdCentre, int Nomatiere, String intitule, int NoChef) {
        this.numprof = numprof;
        this.nomprof = nomprof;
        this.prenomprof = prenomprof;
        this.telp = telp;
        this.mobilep = mobilep;
        this.emailp = emailp;
        this.IdCentre = IdCentre;
        this.Nomatiere = Nomatiere;
        this.intitule = intitule;
        this.NoChef = NoChef;
    }

    public Professeur(int numprof, String nomprof, String prenomprof, String telp, String mobilep, String emailp) {
        this.numprof = numprof;
        this.nomprof = nomprof;
        this.prenomprof = prenomprof;
        this.telp = telp;
        this.mobilep = mobilep;
        this.emailp = emailp;
    }

    public Professeur(int numprof, String nomprof, String prenomprof) {
        this.numprof = numprof;
        this.nomprof = nomprof;
        this.prenomprof = prenomprof;
    }

    /**
     * @return the numprof
     */
    public int getNumprof() {
        return numprof;
    }

    /**
     * @param numprof the numprof to set
     */
    public void setNumprof(int numprof) {
        this.numprof = numprof;
    }

    /**
     * @return the nomprof
     */
    public String getNomprof() {
        return nomprof;
    }

    /**
     * @param nomprof the nomprof to set
     */
    public void setNomprof(String nomprof) {
        this.nomprof = nomprof;
    }

    /**
     * @return the prenomprof
     */
    public String getPrenomprof() {
        return prenomprof;
    }

    /**
     * @param prenomprof the prenomprof to set
     */
    public void setPrenomprof(String prenomprof) {
        this.prenomprof = prenomprof;
    }

    /**
     * @return the telp
     */
    public String getTelp() {
        return telp;
    }

    /**
     * @param telp the telp to set
     */
    public void setTelp(String telp) {
        this.telp = telp;
    }

    /**
     * @return the mobilep
     */
    public String getMobilep() {
        return mobilep;
    }

    /**
     * @param mobilep the mobilep to set
     */
    public void setMobilep(String mobilep) {
        this.mobilep = mobilep;
    }

    /**
     * @return the emailp
     */
    public String getEmailp() {
        return emailp;
    }

    /**
     * @param emailp the emailp to set
     */
    public void setEmailp(String emailp) {
        this.emailp = emailp;
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
     * @return the NoChef
     */
    public int getNoChef() {
        return NoChef;
    }

    /**
     * @param NoChef the NoChef to set
     */
    public void setNoChef(int NoChef) {
        this.NoChef = NoChef;
    }
}
