package Info;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parametres {

    private String username;
    private String password;
    private String fonction;
    private int no;
    private int userId;
    private int centreEmp;// centre de l'employe
    private int annee;
    private int semestre;
    private int IdCentre;// centre choisi pour les rapports

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        try {
            this.username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Parametres.class.getName()).log(Level.SEVERE, null, ex);
        }
    //this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = new String(password.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Parametres.class.getName()).log(Level.SEVERE, null, ex);
        }
    //this.password = password;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getIdCentre() {
        return IdCentre;
    }

    public void setIdCentre(int IdCentre) {
        this.IdCentre = IdCentre;
    }

    public int getCentreEmp() {
        return centreEmp;
    }

    public void setCentreEmp(int centreEmp) {
        this.centreEmp = centreEmp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}