package Prof;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MethodesProf {

    Connection connection;

    public MethodesProf() {
    }

    public List<Professeur> avoirlisteProfs(int annee, int semestre, int IdCentre) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.numprof,t1.nomprof,t1.prenomprof,t1.telp,t1.mobilep,t1.emailp ";
        requete += " from Professeur as t1, Enseignement as t2, Section as t3, Affectation as t4, Matiere as t5 ";
        requete += " where t1.numprof=t2.numprof and t2.NoSection=t3.NoSection and t3.Nomatiere=t5.Nomatiere ";
        requete += " and t3.IdCentre=t4.IdCentre and t3.annee=t4.annee and t3.NoOuverture=t4.NoOuverture and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t1.numprof!=969 and t1.numprof!=1022 and t3.annee=" + annee;

        if (semestre == 1) {
            requete += " and (abs(gradeaff mod 2)=1 or annuelle=1) ";
        }
        if (semestre == 2) {
            requete += " and (abs(gradeaff mod 2)=0 or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t3.IdCentre=" + IdCentre;
        }

        requete += " order by t1.prenomprof,t1.nomprof ";

        ResultSet records;
        List<Professeur> l = new LinkedList<Professeur>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Professeur> avoirProfsMatiere(int annee, int semestre, int IdCentre) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.numprof,t1.nomprof,t1.prenomprof,t1.telp,t1.mobilep,t1.emailp,t3.IdCentre,t3.Nomatiere,t5.intitule ";
        requete += " from Professeur as t1, Enseignement as t2, Section as t3, Affectation as t4, Matiere as t5 ";
        requete += " where t1.numprof=t2.numprof and t2.NoSection=t3.NoSection and t3.Nomatiere=t5.Nomatiere ";
        requete += " and t3.IdCentre=t4.IdCentre and t3.annee=t4.annee and t3.NoOuverture=t4.NoOuverture and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t1.numprof!=969 and t1.numprof!=1022 and t3.annee=" + annee;

        if (semestre == 1) {
            requete += " and (abs(gradeaff mod 2)=1 or annuelle=1) ";
        }
        if (semestre == 2) {
            requete += " and (abs(gradeaff mod 2)=0 or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t3.IdCentre=" + IdCentre;
        }

        requete += " order by t3.IdCentre,t5.intitule,t1.prenomprof,t1.nomprof ";

        ResultSet records;
        List<Professeur> l = new LinkedList<Professeur>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getInt(7), records.getInt(8), records.getString(9), 0));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Professeur> avoirProfsMatiereBloc(int annee, int semestre, int IdCentre) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.numprof,t1.nomprof,t1.prenomprof,t1.telp,t1.mobilep,t1.emailp,t3.IdCentre,t3.Nomatiere,t5.intitule ";
        requete += " from Professeur as t1, Enseignement as t2, Section as t3, Affectation as t4, Matiere as t5 ";
        requete += " where t1.numprof=t2.numprof and t2.NoSection=t3.NoSection and t3.Nomatiere=t5.Nomatiere ";
        requete += " and t3.IdCentre=t4.IdCentre and t3.annee=t4.annee and t3.NoOuverture=t4.NoOuverture and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t1.numprof!=969 and t1.numprof!=1022 and t3.annee=" + annee;

        if (semestre == 1) {
            requete += " and (abs(gradeaff mod 2)=1 or annuelle=1) ";
        }
        if (semestre == 2) {
            requete += " and (abs(gradeaff mod 2)=0 or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t3.IdCentre=" + IdCentre;
        }

        requete += " order by t5.intitule,t3.IdCentre,t1.prenomprof,t1.nomprof ";

        ResultSet records;
        List<Professeur> l = new LinkedList<Professeur>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getInt(7), records.getInt(8), records.getString(9), 0));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Professeur> avoirProfsSpecMatiere(int annee, int semestre, int IdCentre, int spec) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.numprof,t1.nomprof,t1.prenomprof,t1.telp,t1.mobilep,t1.emailp,t3.IdCentre,t3.Nomatiere,t5.intitule ";
        requete += " from Professeur as t1, Enseignement as t2, Section as t3, Affectation as t4, Matiere as t5 ";
        requete += " where t1.numprof=t2.numprof and t2.NoSection=t3.NoSection and t3.Nomatiere=t5.Nomatiere ";
        requete += " and t3.IdCentre=t4.IdCentre and t3.annee=t4.annee and t3.NoOuverture=t4.NoOuverture and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t1.numprof!=969 and t1.numprof!=1022 and t4.spec=" + spec + " and t3.annee=" + annee;

        if (semestre == 1) {
            requete += " and (abs(gradeaff mod 2)=1 or annuelle=1) ";
        }
        if (semestre == 2) {
            requete += " and (abs(gradeaff mod 2)=0 or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t3.IdCentre=" + IdCentre;
        }

        requete += " order by t1.prenomprof,t1.nomprof ";

        ResultSet records;
        List<Professeur> l = new LinkedList<Professeur>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getInt(7), records.getInt(8), records.getString(9), 0));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Professeur> avoirProfsSpec(int annee, int semestre, int IdCentre, int spec) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.numprof,t1.nomprof,t1.prenomprof,t1.telp,t1.mobilep,t1.emailp ";
        requete += " from Professeur as t1, Enseignement as t2, Section as t3, Affectation as t4, Matiere as t5 ";
        requete += " where t1.numprof=t2.numprof and t2.NoSection=t3.NoSection and t3.Nomatiere=t5.Nomatiere ";
        requete += " and t3.IdCentre=t4.IdCentre and t3.annee=t4.annee and t3.NoOuverture=t4.NoOuverture and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t1.numprof!=969 and t1.numprof!=1022 and spec=" + spec + " and t3.annee=" + annee;

        if (semestre == 1) {
            requete += " and (abs(gradeaff mod 2)=1 or annuelle=1) ";
        }
        if (semestre == 2) {
            requete += " and (abs(gradeaff mod 2)=0 or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t3.IdCentre=" + IdCentre;
        }

        requete += " order by t1.prenomprof,t1.nomprof ";

        ResultSet records;
        List<Professeur> l = new LinkedList<Professeur>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Professeur> avoirCoordinateurs(int annee, int semestre, int IdCentre) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.numprof,t1.nomprof,t1.prenomprof,t1.telp,t1.mobilep,t1.emailp,t3.Nomatiere,t5.intitule,t5.NoChef ";
        requete += " from Professeur as t1, Section as t3, Affectation as t4, Matiere as t5 ";
        requete += " where t1.numprof=t5.numprof and t3.Nomatiere=t5.Nomatiere ";
        requete += " and t3.IdCentre=t4.IdCentre and t3.annee=t4.annee and t3.NoOuverture=t4.NoOuverture and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t1.numprof!=969 and t1.numprof!=1022 and t3.annee=" + annee;

        if (semestre == 1) {
            requete += " and (abs(gradeaff mod 2)=1 or annuelle=1) ";
        }
        if (semestre == 2) {
            requete += " and (abs(gradeaff mod 2)=0 or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t3.IdCentre=" + IdCentre;
        }

        requete += " order by t5.intitule,t1.prenomprof,t1.nomprof ";

        ResultSet records;
        List<Professeur> l = new LinkedList<Professeur>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), 0, records.getInt(7), records.getString(8), records.getInt(9)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Professeur> avoirProfesseurNom(String nom, String prenom) throws ClassNotFoundException, SQLException {
        Statement stmt;
        ResultSet records;
        List<Professeur> l = new LinkedList<Professeur>();

        String requete = "";
        if ((!nom.isEmpty()) || (!prenom.isEmpty())) {
            requete = "select numprof,nomprof,prenomprof from Professeur";

            if ((!nom.isEmpty()) && (prenom.isEmpty())) {
                requete += " where instr(nomprof," + "\"" + nom + "\"" + ")>0";
            }

            if ((!nom.isEmpty()) && (!prenom.isEmpty())) {
                requete += " where instr(nomprof," + "\"" + nom + "\"" + ")>0 and instr(prenomprof," + "\"" + prenom + "\"" + ")>0";
            }

            if ((nom.isEmpty()) && (!prenom.isEmpty())) {
                requete += " where instr(prenomprof," + "\"" + prenom + "\"" + ")>0";
            }
            requete += " order by numprof,prenomprof,nomprof";
        }
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3)));
            }
            connection.close();

        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Professeur> avoirInfoProf(int numprof) throws ClassNotFoundException {
        Statement stmt;
        String requete = "select numprof,nomprof,prenomprof,telp,mobilep,emailp ";
        requete += "from Professeur where numprof=" + numprof;

        ResultSet records;

        List<Professeur> l = new LinkedList<Professeur>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();

        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<FicheEnseignement> avoirEnseignemntProf(int numprof, int annee) throws ClassNotFoundException {
        Statement stmt;
        String requete = "select t4.Nomatiere,t4.cnam,t4.intitule,abs(gradeaff mod 2) as semestre,t1.IdCentre,NoGroupe ";
        requete += " from Section as t1, Enseignement as t2, Affectation as t3, Matiere as t4 ";
        requete += " where t1.NoSection=t2.NoSection and t1.Nomatiere=t4.Nomatiere ";
        requete += " and t1.IdCentre=t3.IdCentre and t1.annee=t3.annee and t1.NoOuverture=t3.NoOuverture and t1.Nomatiere=t3.Nomatiere ";
        requete += " and t2.numprof=" + numprof + " and t1.annee=" + annee + " and annuelle=0";

        requete += " UNION select t4.Nomatiere,t4.cnam,t4.intitule, -1 as semestre,t1.IdCentre,NoGroupe ";
        requete += " from Section as t1, Enseignement as t2, Affectation as t3, Matiere as t4 ";
        requete += " where t1.NoSection=t2.NoSection and t1.Nomatiere=t4.Nomatiere ";
        requete += " and t1.IdCentre=t3.IdCentre and t1.annee=t3.annee and t1.NoOuverture=t3.NoOuverture and t1.Nomatiere=t3.Nomatiere ";
        requete += " and t2.numprof=" + numprof + " and t1.annee=" + annee + " and annuelle=1";
        requete += " order by semestre desc, IdCentre, intitule";

        ResultSet records;

        List<FicheEnseignement> l = new LinkedList<FicheEnseignement>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new FicheEnseignement(records.getInt(1), records.getString(2), records.getString(3), records.getInt(4), records.getInt(5), records.getInt(6)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();

        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Professeur> avoirProfsUneMatiere(int annee, int semestre, int IdCentre, int Nomatiere) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.numprof,t1.nomprof,t1.prenomprof,t1.telp,t1.mobilep,t1.emailp,t3.IdCentre,t3.Nomatiere,t5.intitule ";
        requete += " from Professeur as t1, Enseignement as t2, Section as t3, Affectation as t4, Matiere as t5 ";
        requete += " where t1.numprof=t2.numprof and t2.NoSection=t3.NoSection and t3.Nomatiere=t5.Nomatiere ";
        requete += " and t3.IdCentre=t4.IdCentre and t3.annee=t4.annee and t3.NoOuverture=t4.NoOuverture and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t1.numprof!=969 and t1.numprof!=1022 and t3.Nomatiere=" + Nomatiere + " and t3.annee=" + annee;

        if (semestre == 1) {
            requete += " and (abs(gradeaff mod 2)=1 or annuelle=1) ";
        }
        if (semestre == 2) {
            requete += " and (abs(gradeaff mod 2)=0 or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t3.IdCentre=" + IdCentre;
        }

        requete += " order by t3.IdCentre,t1.prenomprof,t1.nomprof ";

        ResultSet records;
        List<Professeur> l = new LinkedList<Professeur>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Professeur(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getInt(7), records.getInt(8), records.getString(9), 0));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesProf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    private DataSource getJdbcDetail() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/jdbc/Detail");
    }
}
