
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="isae.lib.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.TimeZone"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fiche Professeur</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="MP" scope="session" class="Prof.MethodesProf" />
        <jsp:useBean id="IQ" scope="session" class="isae.lib.InitialQuerys" />
        <jsp:useBean id="IFU" scope="session" class="isae.lib.InitialFunctions" />
    </head>
    <body>
        <form>
            <%
        int annee = b.getAnnee();
        int numprof = Integer.parseInt(request.getParameter("numprof"));
        //out.println("Annee: " + annee);
        //out.println("Numero professeur: " + numprof);

        List<Prof.Professeur> prof = MP.avoirInfoProf(numprof);
        List<Prof.FicheEnseignement> ens = MP.avoirEnseignemntProf(numprof, annee);
        if (ens.isEmpty() && prof.isEmpty()) {
            out.println("Pas de données à imprimer.");
        } else {
            %>

            <%-- Entête --%>
            <table>
                <tr>
                    <td align="center" style="width:700px"><h2><u>Fiche Professeur</u></h2></td>
                </tr>

                <tr>
                    <td valign="top" align="right">
                        <%
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                TimeZone local = TimeZone.getDefault();
                sdf.setTimeZone(local);
                String dateString = sdf.format(new Date());
                out.println(dateString);
                        %>
                    </td>
                </tr>
            </table>




            <%-- Informations Professeur--%>
            <table>
                <%for (Prof.Professeur p : prof) {%>
                <tr>
                    <td><b>No. Professeur: </b></td>
                    <td><%=p.getNumprof()%></td>
                </tr>

                <tr>
                    <td><b>Nom Professeur: </b></td>
                    <td><%=p.getPrenomprof()%> <%=p.getNomprof()%></td>
                </tr>

                <tr>
                    <td><b>Téléphone: </b></td>
                    <td><%out.println(IFU.nn(p.getTelp()));%></td>
                </tr>

                <tr>
                    <td><b>Mobile: </b></td>
                    <td><%out.println(IFU.nn(p.getMobilep()));%></td>
                </tr>

                <tr>
                    <td><b>Email: </b></td>
                    <td><%out.println(IFU.nn(p.getEmailp()));%></td>
                </tr>
            </table>
            <br>

            <%}%>




            <%-- Informations sur l'enseignement--%>
            <%if (!ens.isEmpty()) {%>
            <br>
            Enseignement à l'année: <%out.println(annee - 1 + " - " + annee);%>
            <table border="1">
                <tr bgcolor="#B3E4FD">
                    <td><b>Cnam</b></td>
                    <td><b>Nom matière</b></td>
                    <td><b>Semestre</b></td>
                    <td><b>Centre</b></td>
                    <td><b>Groupe</b></td>
                </tr>

                <%for (Prof.FicheEnseignement e : ens) {%>
                <tr>
                    <td><%=e.getCnam()%></td>
                    <td><%=e.getIntitule()%></td>

                    <%if (e.getSemestre() == 1) {%>
                    <td align="center">1</td>
                    <%}%>
                    <%if (e.getSemestre() == 0) {%>
                    <td align="center">2</td>
                    <%}%>
                    <%if (e.getSemestre() == -1) {%>
                    <td align="center">Annuelle</td>
                    <%}%>

                    <td><%out.println(IQ.avoirCentre(e.getIdCentre()));%></td>
                    <td align="center"><%=e.getNoGroupe()%></td>
                </tr>
                <%}%>
            </table>
            <%
                } else {
                    out.println("La liste d'esneignement est vide à l'année: " + (annee - 1) + " - " + annee);
                }
            %>

            <%}%>

        </form>
    </body>
</html>
