
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="Etud.*" %>
<%@ page import="isae.lib.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.TimeZone"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etudiants et matières (ordre centre - matière)</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="ME" scope="session" class="Etud.MethodesEtud" />
        <jsp:useBean id="IQ" scope="session" class="isae.lib.InitialQuerys" />
        <jsp:useBean id="IFU" scope="session" class="isae.lib.InitialFunctions" />
    </head>
    <body>
        <%
        int annee = b.getAnnee();
        int semestre = b.getSemestre();
        int IdCentre = b.getIdCentre();

        //out.println("Annee: " + annee);
        //out.println("Semestre: " + semestre);
        //out.println("IdCentre: " + IdCentre);


        List<Etud.EtudiantInfo> etd = ME.avoirEtudiantsMatiereBloc(annee, semestre, IdCentre);
        if (etd.isEmpty()) {
            out.println("Pas de données à imprimer.");
        } else {
            //out.println("taille:" + etd.size());
%>
        <table>
            <tr>
                <td style="width:400px" valign="top">
                    <font size="+1"><b><u>Institut des Sciences Appliquées et Economiques</u></b></font>
                    <br>
                    <%if (IdCentre == 0) {%>
                    <b>(Tous les centres)</b>
                    <%} else {%>
                    <b>Centre <%out.println(IQ.avoirCentre(IdCentre));%></b>
                    <%}%>
                </td>
                <td style="width:60px"></td>
                <td valign="top" align="right" style="width:230px">
                    <%
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            TimeZone local = TimeZone.getDefault();
            sdf.setTimeZone(local);
            String dateString = sdf.format(new Date());
                    %>

                    <table>
                        <tr valign="top"><td align="left" valign="top"><b>Année: </b><%out.println(annee - 1 + " - " + annee);%></td></tr>
                        <%if (semestre == 0) {%>
                        <tr><td align="left"><b>(Toute l'année)</b></td></tr>
                        <%} else {%>
                        <tr><td align="left"><b>Semestre: </b><%=semestre%></td></tr>
                        <%}%>
                        <tr><td align="left"><%out.println(dateString);%></td></tr>
                    </table>

                </td>
            </tr>
        </table>
        <br><br>

        <b>Etudiants et matières (ordre centre - matière):</b>

        <table border="1">
            <tr bgcolor="#B3E4FD">
                <td><b>Nodossier</b></td>
                <td><b>Nom</b></td>
                <td><b>Prénom</b></td>
                <td><b>Père</b></td>
                <td><b>Téléphone</b></td>
                <td><b>Mobile</b></td>
                <td><b>Email</b></td>
                <td><b>Nom matière</b></td>
                <td><b>Centre</b></td>
            </tr>

            <% for (Etud.EtudiantInfo e : etd) {%>
            <tr>
                <td><%=e.getNodossier()%></td>
                <td><%=e.getNom()%></td>
                <td><%=e.getPrenom()%></td>
                <td><%=e.getPere()%></td>
                <td><%out.println(IFU.nn(e.getTel()));%></td>
                <td><%out.println(IFU.nn(e.getMobile()));%></td>
                <td><%out.println(IFU.nn(e.getEmail()));%></td>
                <td><%=e.getIntitule()%></td>
                <td><%out.println(IQ.avoirCentre(e.getIdCentre()));%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>
