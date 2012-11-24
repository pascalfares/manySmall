
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="Etud.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.UnsupportedEncodingException" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informations Etudiant</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="ME" scope="session" class="Etud.MethodesEtud" />
    </head>
    <body>
        <%
        b.setAnnee(Integer.parseInt(request.getParameter("annee")));
        //out.println("Annee: " + b.getAnnee());

        int x = 0;
        String Nodossier = request.getParameter("Nodossier");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");

        if ((!Nodossier.isEmpty()) || (!prenom.isEmpty()) || (!nom.isEmpty())) {

            try {
                String Nodossier2 = new String(request.getParameter("Nodossier").getBytes("ISO-8859-1"), "UTF-8");
                x = 1;
                Nodossier = Nodossier2;
            } catch (UnsupportedEncodingException ex) {
                out.println("Les caractères saisis ne sont pas valides.");
            }
            // out.println("Nodossier " + Nodossier);



            try {
                String prenom2 = new String(request.getParameter("prenom").getBytes("ISO-8859-1"), "UTF-8");
                x = 1;
                prenom = prenom2;
            } catch (UnsupportedEncodingException ex) {
                out.println("Les caractères saisis ne sont pas valides.");
            }
            // out.println("prenom " + prenom);



            try {
                String nom2 = new String(request.getParameter("nom").getBytes("ISO-8859-1"), "UTF-8");
                x = 1;
                nom = nom2;
            } catch (UnsupportedEncodingException ex) {
                out.println("Les caractères saisis ne sont pas valides.");
            }
            // out.println("nom " + nom + "<br>");


            if (x == 1) {
                List<Etud.EtudiantInfo> etd = ME.avoirEtudiantsNoms(Nodossier, nom, prenom);
                if (etd.isEmpty()) {
        %>

        <font color="blue">
            <% out.println("Pas de données pour les paramètres cherchés.");%>
        </font>
        <%} else {%>

        <b>Etudiants:</b><br>

        <table border="1">
            <tr bgcolor="#B3E4FD">
                <td><b>No. dossier</b></td>
                <td><b>Nom et prénom</b></td>
                <td></td>
            </tr>

            <%for (Etud.EtudiantInfo e : etd) {%>
            <tr>
                <td><%=e.getNodossier()%></td>
                <td><%=e.getNom()%> <%=e.getPrenom()%> <%=e.getPere()%></td>

                <%
    //int ok = 0;
    //List<Etud.FicheEtudiant> ins = ME.avoirInscriptionEtudiant(e.getNoEtud(), b.getAnnee());
    //for (Etud.FicheEtudiant i : ins) {
    //if (i.getIdCentre() == b.getCentreEmp()) {
    //ok = 1;
    //break;
    //}
    //}
%>

                <%
    int ok = 0;
    List<Etud.EtudiantInfo> et = ME.avoirInfoEtudiant(e.getNoEtud());
    for (Etud.EtudiantInfo y : et) {
        if (y.getIdCentre() == b.getCentreEmp()) {
            ok = 1;
            break;
        }
    }
                %>

                <%if (b.getCentreEmp() == 1 || ok == 1) {%>
                <td><a href="etudFiche.jsp?NoEtud=<%=e.getNoEtud()%>" target="info206">Fiche étudiant</a></td>
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
            <% out.println("Vous devez tapez le No dossier, le prénom ou le nom de l'étudiant avant de cliquer sur ce bouton.");%>
        </font>
        <%}%>

    </body>
</html>
