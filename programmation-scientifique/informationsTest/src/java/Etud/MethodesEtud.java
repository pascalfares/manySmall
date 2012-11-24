package Etud;

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

public class MethodesEtud {

    Connection connection;

    public MethodesEtud() {
    }

    public List<EtudiantInfo> avoirlisteEtudiants(int annee, int semestre, int IdCentre) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.NoEtud,t1.Nodossier,t1.nom,t1.prenom,t1.pere,t1.tel,t1.mobile,t1.email,t2.IdCentre ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t2.annee=" + annee;

        if (semestre != 0) {
            requete += " and (semestre=" + semestre + " or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t2.IdCentre=" + IdCentre;
        }

        requete += " order by t2.IdCentre,t1.nom,t1.prenom,t1.pere ";

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getString(7), records.getString(8), records.getInt(9)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<EtudiantInfo> avoirEtudiantsMatiere(int annee, int semestre, int IdCentre) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.NoEtud,t1.Nodossier,t1.nom,t1.prenom,t1.pere,t1.tel,t1.mobile,t1.email,t2.IdCentre,t4.Nomatiere,t4.intitule ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t2.annee=" + annee;

        if (semestre != 0) {
            requete += " and (semestre=" + semestre + " or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t2.IdCentre=" + IdCentre;
        }

        requete += " order by t2.IdCentre,t1.nom,t1.prenom,t1.pere,t4.intitule ";

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getString(7), records.getString(8), records.getInt(9), records.getInt(10), records.getString(11)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<EtudiantInfo> avoirEtudiantsMatiereBloc(int annee, int semestre, int IdCentre) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.NoEtud,t1.Nodossier,t1.nom,t1.prenom,t1.pere,t1.tel,t1.mobile,t1.email,t2.IdCentre,t4.Nomatiere,t4.intitule ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t2.annee=" + annee;

        if (semestre != 0) {
            requete += " and (semestre=" + semestre + " or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t2.IdCentre=" + IdCentre;
        }

        requete += " order by t2.IdCentre,t4.intitule,t1.nom,t1.prenom,t1.pere ";

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getString(7), records.getString(8), records.getInt(9), records.getInt(10), records.getString(11)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<EtudiantInfo> avoirEtudiantsMatiereOrdre(int annee, int semestre, int IdCentre) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.NoEtud,t1.Nodossier,t1.nom,t1.prenom,t1.pere,t1.tel,t1.mobile,t1.email,t2.IdCentre,t4.Nomatiere,t4.intitule ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t2.annee=" + annee;

        if (semestre != 0) {
            requete += " and (semestre=" + semestre + " or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t2.IdCentre=" + IdCentre;
        }

        requete += " order by t4.intitule,t2.IdCentre,t1.nom,t1.prenom,t1.pere ";

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getString(7), records.getString(8), records.getInt(9), records.getInt(10), records.getString(11)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<EtudiantInfo> avoirEtudSpec(int annee, int semestre, int IdCentre, int spec) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.NoEtud,t1.Nodossier,t1.nom,t1.prenom,t1.pere,t1.tel,t1.mobile,t1.email,t2.IdCentre ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t2.spec=" + spec + " and t2.annee=" + annee;

        if (semestre != 0) {
            requete += " and (semestre=" + semestre + " or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t2.IdCentre=" + IdCentre;
        }

        requete += " order by t2.IdCentre,t1.nom,t1.prenom,t1.pere ";

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getString(7), records.getString(8), records.getInt(9)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<EtudiantInfo> avoirEtudSpecMatiere(int annee, int semestre, int IdCentre, int spec) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.NoEtud,t1.Nodossier,t1.nom,t1.prenom,t1.pere,t1.tel,t1.mobile,t1.email,t2.IdCentre,t4.Nomatiere,t4.intitule ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t2.spec=" + spec + " and t2.annee=" + annee;

        if (semestre != 0) {
            requete += " and (semestre=" + semestre + " or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t2.IdCentre=" + IdCentre;
        }

        requete += " order by t2.IdCentre,t1.nom,t1.prenom,t1.pere,t4.intitule ";

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getString(7), records.getString(8), records.getInt(9), records.getInt(10), records.getString(11)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<EtudiantInfo> avoirEtudiantsNoms(String Nodossier, String nom, String prenom) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "";

        if ((!Nodossier.isEmpty()) || (!prenom.isEmpty()) || (!nom.isEmpty())) {

            requete = "select NoEtud,Nodossier,nom,prenom,pere from Etudiant where ";

            if ((Nodossier.isEmpty()) && (!prenom.isEmpty()) && (nom.isEmpty())) {
                requete += " instr(prenom," + "\"" + prenom + "\"" + ")>0";
            }

            if ((Nodossier.isEmpty()) && (!prenom.isEmpty()) && (!nom.isEmpty())) {
                requete += " (instr(prenom," + "\"" + prenom + "\"" + ")>0 and instr(nom," + "\"" + nom + "\"" + ")>0)";
            }

            if ((Nodossier.isEmpty()) && (prenom.isEmpty()) && (!nom.isEmpty())) {
                requete += " instr(nom," + "\"" + nom + "\"" + ")>0";
            }

            if ((!Nodossier.isEmpty()) && (!prenom.isEmpty()) && (nom.isEmpty())) {
                requete += " (instr(Nodossier," + "\"" + Nodossier + "\"" + ")>0 and instr(prenom," + "\"" + prenom + "\"" + ")>0)";
            }

            if ((!Nodossier.isEmpty()) && (!prenom.isEmpty()) && (!nom.isEmpty())) {
                requete += " (instr(Nodossier," + "\"" + Nodossier + "\"" + ")>0  and instr(prenom," + "\"" + prenom + "\"" + ")>0 and instr(nom," + "\"" + nom + "\"" + ")>0)";
            }

            if ((!Nodossier.isEmpty()) && (prenom.isEmpty()) && (!nom.isEmpty())) {
                requete += " (instr(Nodossier," + "\"" + Nodossier + "\"" + ")>0 and instr(nom," + "\"" + nom + "\"" + ")>0)";
            }

            if ((!Nodossier.isEmpty()) && (prenom.isEmpty()) && (nom.isEmpty())) {
                requete += " instr(Nodossier," + "\"" + Nodossier + "\"" + ")>0";
            }

            requete += " order by nom,prenom,pere ";
        }

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();

        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<EtudiantInfo> avoirInfoEtudiant(int NoEtud) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "";
        requete = "select NoEtud,Nodossier,nom,prenom,pere,tel,mobile,email,IdCentre from Etudiant where NoEtud=" + NoEtud;

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();

        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getString(7), records.getString(8), records.getInt(9)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<FicheEtudiant> avoirInscriptionEtudiant(int NoEtud, int annee) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select t3.Nomatiere,cnam,intitule,semestre,t2.IdCentre,t5.payee,t5.dispense ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4, Fiche as t5 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere and t3.NoFiche=t5.NoFiche ";
        requete += " and annuelle=0 and t1.NoEtud=" + NoEtud + " and t2.annee=" + annee;

        requete += " UNION Select t3.Nomatiere,cnam,intitule,0 as semestre,t2.IdCentre,t5.payee,t5.dispense ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4, Fiche as t5 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere and t3.NoFiche=t5.NoFiche ";
        requete += " and annuelle=1 and t1.NoEtud=" + NoEtud + " and t2.annee=" + annee;
        requete += " order by semestre, intitule";

        ResultSet records;
        List<FicheEtudiant> l = new LinkedList<FicheEtudiant>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new FicheEtudiant(records.getInt(1), records.getString(2), records.getString(3), records.getInt(4), records.getInt(5), records.getInt(6), records.getInt(7)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<EtudiantInfo> avoirEtudiantsUneMatiere(int annee, int semestre, int IdCentre, int Nomatiere) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "Select distinct t1.NoEtud,t1.Nodossier,t1.nom,t1.prenom,t1.pere,t1.tel,t1.mobile,t1.email,t2.IdCentre,t4.Nomatiere,t4.intitule ";
        requete += " from Etudiant as t1, Inscription as t2, Etudier_valeurs as t3, Matiere as t4 ";
        requete += " where t1.NoEtud=t2.NoEtud and t2.code_etudier=t3.code_etudier and t3.Nomatiere=t4.Nomatiere ";
        requete += " and t3.Nomatiere=" + Nomatiere + " and t2.annee=" + annee;

        if (semestre != 0) {
            requete += " and (semestre=" + semestre + " or annuelle=1) ";
        }

        if (IdCentre != 0) {
            requete += " and t2.IdCentre=" + IdCentre;
        }

        requete += " order by t2.IdCentre,t1.nom,t1.prenom,t1.pere ";

        ResultSet records;
        List<EtudiantInfo> l = new LinkedList<EtudiantInfo>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new EtudiantInfo(records.getInt(1), records.getString(2), records.getString(3), records.getString(4), records.getString(5), records.getString(6), records.getString(7), records.getString(8), records.getInt(9), records.getInt(10), records.getString(11)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesEtud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    private DataSource getJdbcDetail() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/jdbc/Detail");
    }
}
