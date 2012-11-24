
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="Info.*" %>
<%@ page import="isae.lib.*" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informations</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:setProperty name="b" property="*"/>
        <jsp:useBean id="IQ"  class="isae.lib.InitialQuerys" scope="application" />
        <jsp:useBean id="IL"  class="isae.lib.InitialLists" scope="application" />
        <link rel="stylesheet" type="text/css" href="http://si.isae.edu.lb/themes/cofares.css" />
        <%response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");%>
    </head>
    <body onload="document.forms[0].username.focus()">
        <div id="index-content">
            <form action="index.jsp" method="post">
                <H2 ALIGN="center">Bienvenue au Système d'Information de l'ISAE</H2>
                <H3 ALIGN="center">Accès: Informations</H3>
                <table align="center">
                    <tr>
                        <td>Nom utilisateur:</td>
                        <td><input type="Text" name="username"></td>
                    </tr>
                    <tr>
                        <td>Mot de passe:</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                </table>
                <br><p align="center"> <input type="submit" value="Valider"></p>
            </form>
        </div>


        <p align="center" style="color:red">

            <%
        if ((b.getUsername() != null) && (b.getPassword() != null)) {
            List<isae.lib.User> l = IL.avoirUtilisateur(b.getUsername(), b.getPassword());
            if (l.isEmpty()) {
                out.println("Votre nom et/ou votre mot de passe sont incorrects");
            %>

            <%
                } else {
                    for (isae.lib.User u : l) {
                        if (u.getFonction().equals("employe")) {
                            if (u.getFermer() == 0) {
                                b.setNo(u.getNo());
                                b.setFonction(u.getFonction());
                                b.setCentreEmp(IQ.avoirCentreEmploye(b.getNo()));

                                int lo = 2;
                                String d[] = new String[lo];
                                d[0] = "admin";
                                d[1] = "informations";
                                List<isae.lib.DroitAcces> dl = IL.avoirDroitAcces(u.getUserId());
                                boolean trouver = false;
                                for (isae.lib.DroitAcces dr : dl) {
                                    for (int i = 0; i < d.length; i++) {
                                        if (d[i].equals(dr.getTypedroit())) {
                                            trouver = true;
                                            b.setUserId(dr.getUserID());
                                            break;
                                        }
                                    }
                                    if (trouver == true) {
                                        break;
                                    }
                                }
                                if (trouver == true) {
            %>
            <jsp:forward page="info/homeInfo.jsp"></jsp:forward>
            <%                        } else {
                                out.println("Vous n'avez pas le droit d'accéder à cet interface.");
                            }
                        } else {
                            out.println("Votre compte est expiré.");
                        }
                    } else {
                        out.println("Vous n'avez pas le droit d'accéder à cet interface.");
                    }
                }
            }
        }
            %>
        </p>
    </body>
</html>
