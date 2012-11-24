
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.UnsupportedEncodingException" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informations Professeur</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="MP" scope="session" class="Prof.MethodesProf" />
    </head>
    <body>
        <%
        b.setAnnee(Integer.parseInt(request.getParameter("annee")));
        //out.println("Annee: " + b.getAnnee());

        int x = 0;
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");

        if ((!prenom.isEmpty()) || (!nom.isEmpty())) {
            try {
                String prenomprof = new String(request.getParameter("prenom").getBytes("ISO-8859-1"), "UTF-8");
                x = 1;
                prenom = prenomprof;
            } catch (UnsupportedEncodingException ex) {
                out.println("Les caractères saisis ne sont pas valides.");
            }

            try {
                String nomprof = new String(request.getParameter("nom").getBytes("ISO-8859-1"), "UTF-8");
                x = 1;
                nom = nomprof;
            } catch (UnsupportedEncodingException ex) {
                out.println("Les caractères saisis ne sont pas valides.");
            }

            if (x == 1) {
                List<Prof.Professeur> pro = MP.avoirProfesseurNom(nom, prenom);
                if (pro.isEmpty()) {
        %>

        <font color="blue">
            <%out.println("La liste est vide. Pas de professeurs avec ce nom ou prénom.");%>
        </font>
        <%} else {%>

        <b>Professeurs:</b><br>

        <table border="1">
            <tr bgcolor="#B3E4FD">
                <td><b>Numéro</b></td>
                <td><b>Prénom</b></td>
                <td><b>Nom</b></td>
                <td></td>
            </tr>

            <%for (Prof.Professeur p : pro) {%>
            <tr>
                <td><%=p.getNumprof()%></td>
                <td><%=p.getPrenomprof()%></td>
                <td><%=p.getNomprof()%></td>

                <%
    int ok = 0;
    List<Prof.FicheEnseignement> ens = MP.avoirEnseignemntProf(p.getNumprof(), b.getAnnee());
    for (Prof.FicheEnseignement e : ens) {
        if (e.getIdCentre() == b.getCentreEmp()) {
            ok = 1;
            break;
        }
    }
                %>

                <%if (b.getCentreEmp() == 1 || ok == 1) {%>
                <td><a href="profFiche.jsp?numprof=<%=p.getNumprof()%>" target="info106">Fiche professeur</a></td>
                <%}%>

            </tr>
            <%}%>
        </table>


        <%
                }
            }
        } else {
        %>
        <font color="RED">
            <%out.println("Vous devez tapez le nom ou le prénom du professeur avant de cliquer sur ce bouton.");%>
        </font>
        <%}%>

    </body>
</html>
