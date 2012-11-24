
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
        <title>Fiche Etudiant</title>
        <jsp:useBean id="b" scope="session" class="Info.Parametres" />
        <jsp:useBean id="ME" scope="session" class="Etud.MethodesEtud" />
        <jsp:useBean id="IQ" scope="session" class="isae.lib.InitialQuerys" />
        <jsp:useBean id="IFU" scope="session" class="isae.lib.InitialFunctions" />
    </head>
    <body>
        <form>
            <%
        int annee = b.getAnnee();
        int NoEtud = Integer.parseInt(request.getParameter("NoEtud"));
        //out.println("Annee: " + annee);
        //out.println("NoEtud: " + NoEtud);

        List<Etud.EtudiantInfo> etd = ME.avoirInfoEtudiant(NoEtud);
        List<Etud.FicheEtudiant> ins = ME.avoirInscriptionEtudiant(NoEtud, annee);
        if (etd.isEmpty() && ins.isEmpty()) {
            out.println("Pas de données à imprimer.");
        } else {
            %>

            <%-- Entête --%>
            <table>
                <tr>
                    <td align="center" style="width:700px"><h2><u>Fiche Etudiant</u></h2></td>
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




            <%-- Informations Etudiant--%>
            <table>
                <%for (Etud.EtudiantInfo e : etd) {%>
                <tr>
                    <td><b>No. dossier: </b></td>
                    <td><%=e.getNodossier()%></td>
                </tr>

                <tr>
                    <td><b>Nom étudiant: </b></td>
                    <td><%=e.getNom()%> <%=e.getPrenom()%> <%=e.getPere()%></td>
                </tr>

                <tr>
                    <td><b>Téléphone: </b></td>
                    <td><%out.println(IFU.nn(e.getTel()));%></td>
                </tr>

                <tr>
                    <td><b>Mobile: </b></td>
                    <td><%out.println(IFU.nn(e.getMobile()));%></td>
                </tr>

                <tr>
                    <td><b>Email: </b></td>
                    <td><%out.println(IFU.nn(e.getEmail()));%></td>
                </tr>
            </table>
            <br>

            <%}%>




            <%-- Matières inscrites--%>
            <%if (!ins.isEmpty()) {%>
            <br>
            Inscription à l'année: <%out.println(annee - 1 + " - " + annee);%>
            <table border="1">
                <tr bgcolor="#B3E4FD">
                    <td><b>Cnam</b></td>
                    <td><b>Nom matière</b></td>
                    <td><b>Semestre</b></td>
                    <td><b>Centre</b></td>
                    <td><b>Payée/Dispense</b></td>
                </tr>

                <%for (Etud.FicheEtudiant i : ins) {%>
                <tr>
                    <td><%=i.getCnam()%></td>
                    <td><%=i.getIntitule()%></td>

                    <%if (i.getSemestre() == 0) {%>
                    <td align="center">Annuelle</td>
                    <%} else {%>
                    <td align="center"><%=i.getSemestre()%></td>
                    <%}%>

                    <td><%out.println(IQ.avoirCentre(i.getIdCentre()));%></td>

                    <%if (i.getPayee() == 1 || i.getDispense() == 1) {%>
                    <td align="center">Oui</td>
                    <%} else {%>
                    <td align="center">Non</td>
                    <%}%>

                </tr>
                <%}%>
            </table>
            <%
                } else {
                    out.println("L'étudiant n'est pas inscrit à l'année: " + (annee - 1) + " - " + annee);
                }
            %>

            <%}%>

        </form>
    </body>
</html>
