
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
        <jsp:useBean id="MI" scope="session" class="Info.MethodesInfo" />
        <jsp:useBean id="IQ" scope="session" class="isae.lib.InitialQuerys" />
        <jsp:useBean id="IL" scope="session" class="isae.lib.InitialLists" />
    </head>
    <body>
        <form action="listeRapp.jsp" method="get">
            <b><u>Informations Etudiants:</u></b><br>
            <table>
                <tr>
                    <td><b>Année: </b></td>
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
                    <td style="width:20px"></td>



                    <td><b>Semestre: </b></td>
                    <td>
                        <select name="semestre">
                            <option value="0">Toute l'année</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                    </td>
                    <td style="width:20px"></td>



                    <td><b>Centre: </b></td>

                    <%if (b.getCentreEmp() != 1) {%>
                    <td>
                    <%out.println(IQ.avoirCentre(b.getCentreEmp()));%>
                    <input type="hidden" value="<%=b.getCentreEmp()%>" name="IdCentre">
                    <%} else {%>
                    <td>
                        <select name="IdCentre">
                            <option value="0">Tous</option>
                            <%
    List<isae.lib.Centre> l1 = IL.avoirListeCentre();
    for (isae.lib.Centre c : l1) {
                            %>
                            <option value="<%=c.getIdCentre()%>"><%=c.getNomCentre()%></option>
                            <%}%>
                        </select>
                    </td>
                    <%}%>
                    <td style="width:20px"></td>
                    <td><input type="submit" value="Ok"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
