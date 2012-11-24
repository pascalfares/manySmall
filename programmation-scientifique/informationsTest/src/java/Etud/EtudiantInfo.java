package Etud;

public class EtudiantInfo {

    private int NoEtud;
    private String Nodossier;
    private String nom;
    private String prenom;
    private String pere;
    private String tel;
    private String mobile;
    private String email;
    private int IdCentre;
    private int Nomatiere;
    private String intitule;

    public EtudiantInfo(int NoEtud, String Nodossier, String nom, String prenom, String pere, String tel, String mobile, String email, int IdCentre, int Nomatiere, String intitule) {
        this.NoEtud = NoEtud;
        this.Nodossier = Nodossier;
        this.nom = nom;
        this.prenom = prenom;
        this.pere = pere;
        this.tel = tel;
        this.mobile = mobile;
        this.email = email;
        this.IdCentre = IdCentre;
        this.Nomatiere = Nomatiere;
        this.intitule = intitule;
    }

    public EtudiantInfo(int NoEtud, String Nodossier, String nom, String prenom, String pere, String tel, String mobile, String email, int IdCentre) {
        this.NoEtud = NoEtud;
        this.Nodossier = Nodossier;
        this.nom = nom;
        this.prenom = prenom;
        this.pere = pere;
        this.tel = tel;
        this.mobile = mobile;
        this.email = email;
        this.IdCentre = IdCentre;
    }

    public EtudiantInfo(int NoEtud, String Nodossier, String nom, String prenom, String pere) {
        this.NoEtud = NoEtud;
        this.Nodossier = Nodossier;
        this.nom = nom;
        this.prenom = prenom;
        this.pere = pere;
    }

    /**
     * @return the NoEtud
     */
    public int getNoEtud() {
        return NoEtud;
    }

    /**
     * @param NoEtud the NoEtud to set
     */
    public void setNoEtud(int NoEtud) {
        this.NoEtud = NoEtud;
    }

    /**
     * @return the Nodossier
     */
    public String getNodossier() {
        return Nodossier;
    }

    /**
     * @param Nodossier the Nodossier to set
     */
    public void setNodossier(String Nodossier) {
        this.Nodossier = Nodossier;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the pere
     */
    public String getPere() {
        return pere;
    }

    /**
     * @param pere the pere to set
     */
    public void setPere(String pere) {
        this.pere = pere;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
}
