
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="isae.lib.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etudiants par matière</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="IQ" scope="session" class="isae.lib.InitialQuerys" />
    </head>
    <body onload="document.forms[0].cnam.focus()">

        <form action="matListe.jsp" method="get" target="info3">

            <b><u>Etudiants par matière:</u></b><br>
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
                <tr>
                    <td><b>Code CNAM :</b></td>
                    <td><input type="Text" name="cnam"></td>
                    <td align="center" style="width:30px">ou</td>
                    <td><b>Nom matière :</b></td>
                    <td><input type="Text" name="intitule"></td>
                    <td align="center" style="width:30px"></td>
                    <td><input type="submit" value="Recherche"></td>
                </tr>
            </table>

            <iframe id="info3" name="info3" frameborder="0" scrolling="auto" width="100%"
                    height="3000px">
            </iframe>

        </form>
    </body>
</html>
