
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="isae.lib.*" %>
<%@ page import="Info.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informations</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="IQ"  class="isae.lib.InitialQuerys" scope="application" />
        <link rel="stylesheet" type="text/css" href="/informationsTest/Style/login.css" />
    </head>
    <body>
        <div id="index-content">
            <table>
                <tr>
                    <td style="width:340px"></td>
                    <td><H2>Bienvenue <%out.println(IQ.avoirEmploye(b.getNo()));%></H2></td>
                    <td style="width:220px"></td>
                    <td valign="top"><a href="logout.jsp"><b>Quitter</b></a></td>
                </tr>
            </table>
            <hr>
            <table cellpadding="0" cellspacing="0" width="2000px" height="2000px">
                <td width="180px" height="2000px" valign="top">
                    <a href="prof/homeProf.jsp" target="info1"><b>Informations Professeurs</b></a><br>
                    <a href="prof/profChoix.jsp" target="info1"><b>Fiche professeur</b></a><br><br>
                    
                    <a href="etud/homeEtud.jsp" target="info1"><b>Informations Etudiants</b></a><br>
                    <a href="etud/etudChoix.jsp" target="info1"><b>Fiche étudiant</b></a>
                </td>
                <td width="1820px" height="2000px" valign="top">
                <iframe id="info1" name="info1" frameborder="0" scrolling="auto" width="1820px"
                        height="3000px">
                </iframe>
            </table>
        </div>
    </body>
</html>
