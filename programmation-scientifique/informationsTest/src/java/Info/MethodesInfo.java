package Info;

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

public class MethodesInfo {

    Connection connection;

    public MethodesInfo() {
    }

    public int avoirAnneeCour() throws ClassNotFoundException {
        Statement stmt;
        String requete = "select annee from SemestreCourant";
        ResultSet records;
        int x = 0;
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                x = records.getInt(1);
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public List<isae.lib.Annee> avoirAnnees2010() throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "select annee from ListeAnnees where annee>='2010' order by annee desc ";
        ResultSet records;
        List<isae.lib.Annee> l = new LinkedList<isae.lib.Annee>();
        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new isae.lib.Annee(records.getInt(1)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Info.Matiere> avoirListeMatieres(String cnam, String intitule) throws ClassNotFoundException, SQLException {
        Statement stmt;
        String requete = "";

        if ((!cnam.isEmpty()) || (!intitule.isEmpty())) {
            requete = "select Nomatiere,cnam,intitule from Matiere where ";

            if ((!cnam.isEmpty()) && (intitule.isEmpty())) {
                requete += " instr(cnam," + "\"" + cnam + "\"" + ")>0";
            }

            if ((!cnam.isEmpty()) && (!intitule.isEmpty())) {
                requete += " (instr(cnam," + "\"" + cnam + "\"" + ")>0 or instr(intitule," + "\"" + intitule + "\"" + ")>0)";
            }

            if ((cnam.isEmpty()) && (!intitule.isEmpty())) {
                requete += " instr(intitule," + "\"" + intitule + "\"" + ")>0";
            }
            requete += " order by intitule asc";
        }

        ResultSet records;
        List<Info.Matiere> l = new LinkedList<Info.Matiere>();

        try {
            connection = getJdbcDetail().getConnection();
            stmt = connection.createStatement();
            records = stmt.executeQuery(requete);
            while (records.next()) {
                l.add(new Info.Matiere(records.getInt(1), records.getString(2), records.getString(3)));
            }
            connection.close();
        } catch (SQLException sqlException) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MethodesInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlException.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(MethodesInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    private DataSource getJdbcDetail() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/jdbc/Detail");
    }
}
