
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="isae.lib.*" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informations Etudiants</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="IQ" scope="session" class="isae.lib.InitialQuerys" />
        <jsp:useBean id="IL" scope="session" class="isae.lib.InitialLists" />
    </head>
    <body>
        <b><u>Informations Etudiants:</u></b><br>
        <%
        b.setAnnee(Integer.parseInt(request.getParameter("annee")));
        b.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        b.setIdCentre(Integer.parseInt(request.getParameter("IdCentre")));
        //out.println("Annee: " + b.getAnnee());
        //out.println("Semestre: " + b.getSemestre());
        //out.println("Centre: " + b.getIdCentre());
%>

        <table>
            <tr>
                <td><b>Année:</b></td>
                <td><%out.println(b.getAnnee());%></td>
                <td style="width:20px"></td>

                <td><b>Semestre:</b></td>
                <%if (b.getSemestre() == 0) {%>
                <td>Toute l'année</td>
                <%} else {%>
                <td><%out.println(b.getSemestre());%></td>
                <%}%>
                <td style="width:20px"></td>

                <td><b>Centre:</b></td>
                <%if (b.getIdCentre() == 0) {%>
                <td>Tous</td>
                <%} else {%>
                <td><%out.println(IQ.avoirCentre(b.getIdCentre()));%></td>
                <%}%>
            </tr>
        </table>
        <br>

        <table>
            <tr><td><a href="listeEtud.jsp" target="info200">Liste étudiants</a></td></tr>
            <tr><td><a href="etudMatiere.jsp" target="info201">Etudiants et matières (ordre centre - étudiant)</a></td></tr>
            <tr><td><a href="etudMatiereBloc.jsp" target="info202">Etudiants et matières (ordre centre - matière)</a></td></tr>
            <%if (b.getCentreEmp() == 1) {%>
            <tr><td><a href="etudMatiereOrdre.jsp" target="info203">Etudiants et matières (ordre matière - centre)</a></td></tr>
            <%}%>
            <tr><td><a href="choixMat.jsp">Etudiants par matière</a></td></tr>
        </table>
        <br>

        <table>
            <tr>
                <td><b>Liste étudiants par spécialité:</b></td>
                <form action="etudSpec.jsp" method="get" target="info204">
                    <td>
                        <select name="spec">
                            <%
        List<isae.lib.Specialite> sp = IL.avoirListeSpec();
        for (isae.lib.Specialite s : sp) {
                            %>
                            <option value="<%=s.getNospec()%>"><%=s.getNomspec()%></option>
                            <%}%>
                        </select>
                    </td>
                    <td style="width:10px"></td>
                    <td><input type="checkbox" name="choix">Avec matières</td>
                    <td style="width:10px"></td>
                    <td><input type="submit" value="Ok"></td>
                </form>
            </tr>
        </table>
    </body>
</html>
