
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choix professeur</title>
        <jsp:useBean id="MI" scope="session" class="Info.MethodesInfo" />
    </head>
    <body>
        <form action="profListe.jsp" method="get" target="info2">
            <b><u>Fiche professeur:</u></b>
            <table>
                <tr>
                    <td>Année: </td>
                    <td>
                        <select name="annee">
                            <%
        int anneeCour = MI.avoirAnneeCour();
        List<isae.lib.Annee> la = MI.avoirAnnees2010();
        for (isae.lib.Annee a : la) {
            if (anneeCour != a.getAnnee()) {
                            %>
                            <option value="<%=a.getAnnee()%>"><%=a.getAnnee()%></option>
                            <% } else {%>
                            <option selected value="<%=a.getAnnee()%>"><%=a.getAnnee()%></option>
                            <% }
        }%>
                        </select>
                    </td>
                </tr>
                <tr style="height:20px"></tr>

                <tr>
                    <td>Tapez le prénom du professeur :</td>
                    <td><input type="Text" name="prenom"></td>
                </tr>
                <tr><td align="center"><b>et/ou</b></td></tr>
                <tr>
                    <td>Tapez le nom du professeur :</td>
                    <td><input type="Text" name="nom"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Recherche"></td>
                </tr>
            </table>

            <iframe id="info2" name="info2" frameborder="0" scrolling="auto" width="100%"
                    height="3000px">
            </iframe>

        </form>
    </body>
</html>
