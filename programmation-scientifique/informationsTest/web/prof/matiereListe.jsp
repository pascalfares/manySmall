
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.UnsupportedEncodingException" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professeurs par matière</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="MI" scope="session" class="Info.MethodesInfo" />
    </head>
    <body>

        <%
        int x = 0;
        String cnam = request.getParameter("cnam");
        String intitule = request.getParameter("intitule");

        if ((!cnam.isEmpty()) || (!intitule.isEmpty())) {
            try {
                String cnam2 = new String(request.getParameter("cnam").getBytes("ISO-8859-1"), "UTF-8");
                x = 1;
                cnam = cnam2;
            } catch (UnsupportedEncodingException ex) {
                out.println("Les caractères saisis ne sont pas valides.");
            }
            // out.println("cnam: " + cnam);

            try {
                String intitule2 = new String(request.getParameter("intitule").getBytes("ISO-8859-1"), "UTF-8");
                x = 1;
                intitule = intitule2;
            } catch (UnsupportedEncodingException ex) {
                out.println("Les caractères saisis ne sont pas valides.");
            }
            // out.println("intitule: " + intitule + "<br>");


            if (x == 1) {
                List<Info.Matiere> lm = MI.avoirListeMatieres(cnam, intitule);
                if (lm.isEmpty()) {
        %>
        <font color="blue">
            <% out.println("Pas de données pour les paramètres cherchés.");%>
        </font>

        <%} else {%>

        <br>
        <table border="1">
            <tr bgcolor="#B3E4FD">
                <td><b>CNAM</b></td>
                <td><b>Intitule</b></td>
                <td></td>
            </tr>

            <% for (Info.Matiere e : lm) {%>
            <tr>
                <td><%=e.getCnam()%></td>
                <td style="width:500px"><%=e.getIntitule()%></td>
                <td><a href="matiereInfo.jsp?Nomatiere=<%=e.getNomatiere()%>" target="info105">Ok</a></td>
            </tr>
            <%}%>
        </table>


        <%
                }
            }
        } else {
        %>

        <font color="RED">
            <% out.println("Vous devez tapez le code CNAM ou une partie du nom de la matière avant de cliquer sur ce bouton.");%>
        </font>
        <%}%>

    </body>
</html>
